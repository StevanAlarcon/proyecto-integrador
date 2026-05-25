package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.dto.TestimonialDTO;
import dev.josephalvarez.proyectointegrador.model.entity.Testimonial;
import dev.josephalvarez.proyectointegrador.model.service.TestimonialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/testimonials")
public class TestimonialController {

    private final TestimonialService service;

    public TestimonialController(TestimonialService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("testimonials", service.findAll());
        return "admin/testimonials/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("testimonialRequest", TestimonialDTO.class);
        return "admin/testimonials/create";
    }

    @PostMapping
    public String create(@ModelAttribute TestimonialDTO dto) {
        service.create(dto);
        return "redirect:/testimonials";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Testimonial> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Editar Testimonio");
            return "error/not-found";
        }
        model.addAttribute("testimonial", result.get());
        return "admin/testimonials/update";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute TestimonialDTO dto, Model model) {
        try {
            service.update(id, dto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Editar Testimonio");
            return "error/not-found";
        }
        return "redirect:/testimonials";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Optional<Testimonial> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Eliminar Testimonio");
            return "error/not-found";
        }
        model.addAttribute("testimonial", result.get());
        return "admin/testimonials/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Eliminar Testimonio");
            return "error/not-found";
        }
        return "redirect:/testimonials";
    }
}
