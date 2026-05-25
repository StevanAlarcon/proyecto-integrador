package dev.josephalvarez.proyectointegrador.model.service;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.dto.ContactRequestDTO;
import dev.josephalvarez.proyectointegrador.model.entity.ContactRequest;
import dev.josephalvarez.proyectointegrador.model.repository.ContactRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ContactRequestService {

    private final ContactRequestRepository repository;

    public ContactRequestService(ContactRequestRepository repository) {
        this.repository = repository;
    }

    public List<ContactRequest> findAll() { return repository.findAll(); }

    public List<ContactRequest> findByPurpose(Purpose purpose) {
        return repository.findAllByPurpose(purpose);
    }

    public Optional<ContactRequest> findById(Long id) { return repository.findById(id); }

    public void create(ContactRequestDTO dto) {
        ContactRequest cr = new ContactRequest();
        cr.setName(dto.name());
        cr.setEmail(dto.email());
        cr.setPhoneNumber(dto.phoneNumber());
        cr.setPurpose(dto.purpose());
        cr.setCreateDate(LocalDateTime.now());
        repository.save(cr);
    }

    public void delete(Long id) throws EntityNotFoundException {
        ContactRequest cr = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ContactRequest with id " + id + " not found"));
        repository.delete(cr);
    }
}

