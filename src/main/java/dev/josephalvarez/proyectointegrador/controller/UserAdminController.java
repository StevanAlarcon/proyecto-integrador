package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.dto.CreateAdminDTO;
import dev.josephalvarez.proyectointegrador.model.dto.UpdateAdminDTO;
import dev.josephalvarez.proyectointegrador.model.entity.Admin;
import dev.josephalvarez.proyectointegrador.model.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class UserAdminController {

    private final AdminService service;

    public UserAdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("admins", service.findAll());
        return "admin/user/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("nameMaxLength",     Admin.NAME_MAX_LENGTH);
        model.addAttribute("surnameMaxLength",  Admin.SURNAME_MAX_LENGTH);
        model.addAttribute("emailMaxLength",    Admin.EMAIL_MAX_LENGTH);
        model.addAttribute("passwordMaxLength", Admin.PASSWORD_MAX_LENGTH);
        return "admin/user/create";
    }

    @PostMapping
    public String create(@ModelAttribute CreateAdminDTO dto) {
        service.create(dto);
        return "redirect:/admins";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Admin> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Editar Administrador");
            return "error/not-found";
        }
        model.addAttribute("admin", result.get());
        model.addAttribute("nameMaxLength",     Admin.NAME_MAX_LENGTH);
        model.addAttribute("surnameMaxLength",  Admin.SURNAME_MAX_LENGTH);
        model.addAttribute("emailMaxLength",    Admin.EMAIL_MAX_LENGTH);
        model.addAttribute("passwordMaxLength", Admin.PASSWORD_MAX_LENGTH);
        return "admin/user/update";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute UpdateAdminDTO dto, Model model) {
        try {
            service.update(id, dto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Editar Administrador");
            return "error/not-found";
        }
        return "redirect:/admins";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Optional<Admin> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Eliminar Administrador");
            return "error/not-found";
        }
        model.addAttribute("admin", result.get());
        return "admin/user/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Eliminar Administrador");
            return "error/not-found";
        }
        return "redirect:/admins";
    }
}
