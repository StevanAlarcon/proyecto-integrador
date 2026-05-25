package dev.josephalvarez.proyectointegrador.model.dto;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.entity.ContactRequest;

import java.time.LocalDateTime;

public record ContactRequestDTO(
        String name,
        String email,
        String phoneNumber,
        Purpose purpose,
        LocalDateTime createDate
) {
    public ContactRequest toEntity() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setName(name);
        contactRequest.setEmail(email);
        contactRequest.setPhoneNumber(phoneNumber);
        contactRequest.setPurpose(purpose);
        contactRequest.setCreateDate(createDate);

        return contactRequest;
    }
}