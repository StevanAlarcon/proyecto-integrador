package dev.josephalvarez.proyectointegrador.model.repository;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.entity.Admin;
import dev.josephalvarez.proyectointegrador.model.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    List<ContactRequest> findAllByPurpose(Purpose purpose);
}