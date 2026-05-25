package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.dto.ContactRequestDTO;
import dev.josephalvarez.proyectointegrador.model.service.ContactRequestService;
import dev.josephalvarez.proyectointegrador.model.service.NewsService;
import dev.josephalvarez.proyectointegrador.model.service.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final NewsService newsService;
    private final TestimonialService testimonialService;

    public HomeController(NewsService newsService,
                          TestimonialService testimonialService) {
        this.newsService = newsService;
        this.testimonialService = testimonialService;

    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("news",         newsService.findPublished());
        model.addAttribute("testimonials", testimonialService.findAll());
        return "public/home";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("contactRequest",
                new ContactRequestDTO(null, null, null, null, null));
        model.addAttribute("purposes", Purpose.values());
        return "public/contacto";
    }
}
