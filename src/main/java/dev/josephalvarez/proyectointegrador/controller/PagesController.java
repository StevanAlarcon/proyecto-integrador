package dev.josephalvarez.proyectointegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {

    @GetMapping("/shows")
    public String shows() {
        return "public/pages/shows";
    }

    @GetMapping("/edifica")
    public String edifica() {
        return "public/pages/edifica";
    }
}
