package com.example.pruebaspring.controller;

import com.example.pruebaspring.model.Opcion;
import com.example.pruebaspring.model.Partida;
import com.example.pruebaspring.model.Pregunta;
import com.example.pruebaspring.service.OpcionService;
import com.example.pruebaspring.service.PartidaService;
import com.example.pruebaspring.service.PreguntaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class PartidaController {

    @Autowired
    PreguntaService preguntaService;
    @Autowired
    OpcionService opcionService;

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
    String valorarPartida(@RequestParam Map<String,String> respuestas,HttpSession session,Model model){

        int puntos = 0;

        //Validamos que el usuario conteste todas las preguntas
        //En caso que no las conteste todas, envio el error y recupero las preguntas de la partida de la session
        if(respuestas.size()!=5){
            List<Pregunta> lista = (List<Pregunta>)session.getAttribute("preguntasPartida");
            model.addAttribute("error","Debes contestar todas las preguntas");
            model.addAttribute("preguntas",lista);
            return "partida";
        }


        for (Map.Entry<String, String> entry : respuestas.entrySet()) {
            String preg = entry.getKey();     // clave
            String opc = entry.getValue();   // valor

            //Recuperamos la pregunta
            Pregunta p = preguntaService.getPreguntaConId(Long.parseLong(preg));

            //Recuperamos la opcion
            Opcion o = opcionService.getOpcionConId(Long.parseLong(opc));

            //Si existe la opcion y es correcta sumo un punto
            if(o != null && o.isEsCorrecta()){
                puntos+=1;
            }

        }

        //Elimino las preguntas de la partida pues para una proxima partida las preguntas y opciones ademas de poder ser distintas
        //tendran un orden distinto
        session.removeAttribute("preguntasPartida");

        //Creo la partida utilizando el servicio
        Partida p = partidaService.crearPartida(puntos);


        model.addAttribute("partida",p);

        return "resultado";
    }
}
