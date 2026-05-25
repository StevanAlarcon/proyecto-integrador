package dev.josephalvarez.proyectointegrador.model.dto;


public record UpdateAdminDTO(
        String name,
        String surname,
        String email,
        String password
) {}