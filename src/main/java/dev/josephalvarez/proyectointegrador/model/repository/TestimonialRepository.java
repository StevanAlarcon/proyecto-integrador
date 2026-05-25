package dev.josephalvarez.proyectointegrador.model.repository;

import dev.josephalvarez.proyectointegrador.model.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    Optional<Testimonial> findByCreateDate(LocalDateTime createDate);
}
