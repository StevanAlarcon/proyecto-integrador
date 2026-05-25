package dev.josephalvarez.proyectointegrador.model.entity;

import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.dto.ContactRequestDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="contact_request")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false,length = 50)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    @Column(nullable = false)
    private LocalDateTime createDate;

    public ContactRequest() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void replaceFieldsWith(ContactRequestDTO contactRequestDTO, Purpose purpose){
        setName(contactRequestDTO.name());
        setEmail(contactRequestDTO.email());
        setPhoneNumber(contactRequestDTO.phoneNumber());
        setPurpose(purpose);
        setCreateDate(contactRequestDTO.createDate());
    }

}
