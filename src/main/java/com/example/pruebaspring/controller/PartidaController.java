package com.example.pruebaspring.controller;

import com.example.pruebaspring.model.Opcion;
import com.example.pruebaspring.model.Partida;
import com.example.pruebaspring.model.Pregunta;
import com.example.pruebaspring.model.Usuario;
import com.example.pruebaspring.service.OpcionService;
import com.example.pruebaspring.service.PartidaService;
import com.example.pruebaspring.service.PreguntaService;
import com.example.pruebaspring.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class PartidaController {

    @Autowired
    PreguntaService preguntaService;
    @Autowired
    OpcionService opcionService;

    @Autowired
    UsuarioDetailsService usuarioDetailsService;

    @Autowired
    PartidaService partidaService;

    @GetMapping("/partida")
    String partida(Model model, HttpSession session){
        List<Pregunta> lista =  preguntaService.obtenerPreguntasAleatorias();
        session.setAttribute("preguntasPartida", lista);
        model.addAttribute("preguntas",lista);
        return "partida";
    }

    @PostMapping("/partida")
    String valorarPartida(@RequestParam("_csrf") String csrfToken,@RequestParam Map<String,String> respuestas, HttpSession session, Model model, Principal usuarioLogueado){
        int puntos = 0;


        //Validamos que el usuario conteste todas las preguntas
        //En caso que no las conteste todas, envio el error y recupero las preguntas de la partida de la session
        if(respuestas.size() < 5){
            List<Pregunta> lista = (List<Pregunta>)session.getAttribute("preguntasPartida");
            model.addAttribute("error","Debes contestar todas las preguntas");
            model.addAttribute("preguntas",lista);
            return "partida";
        }


        for (Map.Entry<String, String> entry : respuestas.entrySet()) {
            String key = entry.getKey();

            if (key.equals("_csrf")) continue; // ⚠️ ignora este campo

            Long idPregunta = Long.parseLong(key);
            Long idOpcion = Long.parseLong(entry.getValue());

            Pregunta p = preguntaService.getPreguntaConId(idPregunta);
            Opcion o = opcionService.getOpcionConId(idOpcion);

            if (o != null && o.isEsCorrecta()) {
                puntos++;
            }
        }

        //Elimino las preguntas de la partida pues para una proxima partida las preguntas y opciones ademas de poder ser distintas
        //tendran un orden distinto
        session.removeAttribute("preguntasPartida");


        //Busco el usuario logueado
        Usuario u = usuarioDetailsService.getUserByUsername(usuarioLogueado.getName());

        //Creo la partida utilizando el servicio
        Partida p = partidaService.crearPartida(puntos,u);


        model.addAttribute("partida",p);
        model.addAttribute("usuario",usuarioLogueado.getName());
        return "resultado";
    }
}
