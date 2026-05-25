package dev.josephalvarez.proyectointegrador.model.service;

import dev.josephalvarez.proyectointegrador.model.constant.NewsStatus;
import dev.josephalvarez.proyectointegrador.model.dto.NewsDTO;
import dev.josephalvarez.proyectointegrador.model.entity.News;
import dev.josephalvarez.proyectointegrador.model.repository.NewsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<News> findAll() {
        return repository.findAllByOrderByPublishDate();
    }

    public List<News> findPublished() {
        return repository.findByStatusOrderByPublishDate(NewsStatus.STATE_PUBLISHED);
    }

    public Optional<News> findById(Long id) {
        return repository.findById(id);
    }

    public void create(NewsDTO dto) {
        News news = new News();
        news.setTitle(dto.title());
        news.setSummary(dto.summary());
        news.setContent(dto.content());
        news.setImageUrl(dto.imageUrl());
        news.setStatus(dto.status());
        news.setPublishDate(LocalDateTime.now());
        news.setAuthor(dto.author());
        repository.save(news);
    }

    public void update(Long id, NewsDTO dto) throws EntityNotFoundException {
        News news = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News with id " + id + " not found"));
        news.replaceFieldsWith(dto, dto.status());
        repository.save(news);
    }

    public void delete(Long id) throws EntityNotFoundException {
        News news = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News with id " + id + " not found"));
        repository.delete(news);
    }
}