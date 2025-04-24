package com.example.pruebaspring.controller;

import com.example.pruebaspring.dto.RankingDTO;
import com.example.pruebaspring.model.Pregunta;
import com.example.pruebaspring.service.PartidaService;
import com.example.pruebaspring.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    PartidaService partidaService;

    @GetMapping("/index")
    String index(Principal usuarioLogueado,Model model){

        model.addAttribute("ranking",partidaService.primerasCincoPosiciones());
        model.addAttribute("user",usuarioLogueado.getName());
        return "index";
    }


}
