package dev.josephalvarez.proyectointegrador.model.entity;

import dev.josephalvarez.proyectointegrador.model.dto.UpdateAdminDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "app_admin")
public class Admin {

    public static final int NAME_MAX_LENGTH     = 50;
    public static final int SURNAME_MAX_LENGTH  = 50;
    public static final int EMAIL_MAX_LENGTH    = 100;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(nullable = false, length = NAME_MAX_LENGTH)
    private String name;

    @Column(nullable = false, length = SURNAME_MAX_LENGTH)
    private String surname;

    @Column(nullable = false, length = EMAIL_MAX_LENGTH, unique = true)
    private String email;

    @Column(nullable = false, length = PASSWORD_MAX_LENGTH)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public Admin() {}

    public Long getAdminId()                { return adminId; }

    public String getName()                 { return name; }
    public void   setName(String name)      { this.name = name; }

    public String getSurname()                  { return surname; }
    public void   setSurname(String surname)    { this.surname = surname; }

    public String getEmail()                { return email; }
    public void   setEmail(String email)    { this.email = email; }

    public String getPassword()                  { return password; }
    public void   setPassword(String password)   { this.password = password; }



    public void replaceFieldsWith(UpdateAdminDTO dto) {
        setName(dto.name());
        setSurname(dto.surname());
        setEmail(dto.email());
    }
}
