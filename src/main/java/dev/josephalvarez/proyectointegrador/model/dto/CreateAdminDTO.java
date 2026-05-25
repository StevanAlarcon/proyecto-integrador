package dev.josephalvarez.proyectointegrador.model.dto;

public record CreateAdminDTO(
        String name,
        String surname,
        String email,
        String password
) {}
