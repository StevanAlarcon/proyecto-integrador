package dev.josephalvarez.proyectointegrador.model.service;

import dev.josephalvarez.proyectointegrador.model.dto.TestimonialDTO;
import dev.josephalvarez.proyectointegrador.model.entity.Testimonial;
import dev.josephalvarez.proyectointegrador.model.repository.TestimonialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    private final TestimonialRepository repository;

    public TestimonialService(TestimonialRepository repository) {
        this.repository = repository;
    }

    public List<Testimonial> findAll() { return repository.findAll(); }

    public Optional<Testimonial> findById(Long id) { return repository.findById(id); }

    public void create(TestimonialDTO dto) {
        Testimonial testimonial = new Testimonial();
        testimonial.setName(dto.name());
        testimonial.setPhotoUrl(dto.photoUrl());
        testimonial.setInstagramUrl(dto.InstagramUrl());
        testimonial.setFacebookUrl(dto.FacebookUrl());
        testimonial.setCreateDate(LocalDateTime.now());
        repository.save(testimonial);
    }

    public void update(Long id, TestimonialDTO dto) throws EntityNotFoundException {
        Testimonial testimonial = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonial with id " + id + " not found"));
        testimonial.replaceFields(dto);
        repository.save(testimonial);
    }

    public void delete(Long id) throws EntityNotFoundException {
        Testimonial testimonial = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonial with id " + id + " not found"));
        repository.delete(testimonial);
    }
}
