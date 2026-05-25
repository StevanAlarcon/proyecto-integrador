package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.dto.ContactRequestDTO;
import dev.josephalvarez.proyectointegrador.model.entity.ContactRequest;
import dev.josephalvarez.proyectointegrador.model.service.ContactRequestService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contact-requests")
public class ContactRequestController {

    private final ContactRequestService service;

    public ContactRequestController(ContactRequestService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public String create(@ModelAttribute ContactRequestDTO dto) {
        service.create(dto);
        return "redirect:/contacto?success=contact";
    }

    @GetMapping
    public String list(@RequestParam(required = false) Purpose purpose, Model model) {
        List<ContactRequest> list;
        if (purpose != null) {
            list = service.findByPurpose(purpose);
        } else {
            list = service.findAll();
        }
        model.addAttribute("contactRequests", list);
        model.addAttribute("purposes", Purpose.values());
        model.addAttribute("selectedPurpose", purpose);
        return "admin/contact-requests/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<ContactRequest> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Solicitud de Contacto");
            return "error/not-found";
        }
        model.addAttribute("contactRequest", result.get());
        return "admin/contact-requests/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Optional<ContactRequest> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Eliminar Solicitud");
            return "error/not-found";
        }
        model.addAttribute("contactRequest", result.get());
        return "admin/contact-requests/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Eliminar Solicitud");
            return "error/not-found";
        }
        return "redirect:/contact-requests";
    }
}
