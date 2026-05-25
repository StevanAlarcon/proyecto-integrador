package dev.josephalvarez.proyectointegrador.model.repository;

import dev.josephalvarez.proyectointegrador.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
