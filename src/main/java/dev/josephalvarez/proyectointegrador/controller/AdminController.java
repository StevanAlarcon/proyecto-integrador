package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.service.AdminService;
import dev.josephalvarez.proyectointegrador.model.service.ContactRequestService;
import dev.josephalvarez.proyectointegrador.model.service.NewsService;
import dev.josephalvarez.proyectointegrador.model.service.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ContactRequestService contactRequestService;
    private final NewsService newsService;
    private final TestimonialService testimonialService;
    private final AdminService adminService;

    public AdminController(ContactRequestService contactRequestService,
                           NewsService newsService,
                           TestimonialService testimonialService,
                           AdminService adminService) {
        this.contactRequestService = contactRequestService;
        this.newsService = newsService;
        this.testimonialService = testimonialService;
        this.adminService = adminService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("totalContactRequests", contactRequestService.findAll().size());
        model.addAttribute("totalNews",            newsService.findAll().size());
        model.addAttribute("totalTestimonials",    testimonialService.findAll().size());
        model.addAttribute("totalAdmins",          adminService.findAll().size());
        return "admin/dashboard";
    }
}
