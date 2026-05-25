package dev.josephalvarez.proyectointegrador.controller;

import dev.josephalvarez.proyectointegrador.model.constant.NewsStatus;
import dev.josephalvarez.proyectointegrador.model.dto.NewsDTO;
import dev.josephalvarez.proyectointegrador.model.entity.News;
import dev.josephalvarez.proyectointegrador.model.service.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService service;

    public NewsController(NewsService service) {
        this.service = service;
    }

    // ── PÚBLICO ────────────────────────────────────────────

    @GetMapping("/public")
    public String publicList(Model model) {
        model.addAttribute("newsList", service.findPublished());
        return "public/public-list";
    }

    @GetMapping("/public/{id}")
    public String publicDetail(@PathVariable Long id, Model model) {
        Optional<News> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Noticia");
            return "error/not-found";
        }
        model.addAttribute("news", result.get());
        return "public/public-detail";
    }

    // ── ADMIN ──────────────────────────────────────────────

    @GetMapping
    public String list(Model model) {
        model.addAttribute("newsList", service.findAll());
        return "admin/news/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("newsRequest", NewsDTO.class);
        model.addAttribute("newsStatuses", NewsStatus.values());
        return "admin/news/create";
    }

    @PostMapping
    public String create(@ModelAttribute NewsDTO dto) {
        service.create(dto);
        return "redirect:/news";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<News> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Editar Noticia");
            return "error/not-found";
        }
        model.addAttribute("news", result.get());
        model.addAttribute("newsStatuses", NewsStatus.values());
        return "admin/news/update";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute NewsDTO dto, Model model) {
        try {
            service.update(id, dto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Editar Noticia");
            return "error/not-found";
        }
        return "redirect:/news";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Optional<News> result = service.findById(id);
        if (result.isEmpty()) {
            model.addAttribute("title", "Eliminar Noticia");
            return "error/not-found";
        }
        model.addAttribute("news", result.get());
        return "admin/news/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            model.addAttribute("title", "Eliminar Noticia");
            return "error/not-found";
        }
        return "redirect:/news";
    }
}
