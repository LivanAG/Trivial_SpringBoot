package com.example.pruebaspring.controller;

import com.example.pruebaspring.model.Pregunta;
import com.example.pruebaspring.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {



    @GetMapping("/index")
    String index(){
        return "index";
    }


}
