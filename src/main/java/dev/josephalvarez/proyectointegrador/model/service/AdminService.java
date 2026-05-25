package dev.josephalvarez.proyectointegrador.model.service;

import dev.josephalvarez.proyectointegrador.model.dto.CreateAdminDTO;
import dev.josephalvarez.proyectointegrador.model.dto.UpdateAdminDTO;
import dev.josephalvarez.proyectointegrador.model.entity.Admin;
import dev.josephalvarez.proyectointegrador.model.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {

    /** Authority granted to every admin account. */
    public static final String AUTHORITY = "ROLE_ADMIN";

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    public void create(CreateAdminDTO dto) {
        Admin admin = new Admin();
        admin.setName(dto.name());
        admin.setSurname(dto.surname());
        admin.setEmail(dto.email());
        admin.setPassword(passwordEncoder.encode(dto.password()));
        adminRepository.save(admin);
    }

    public void update(Long id, UpdateAdminDTO dto) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin with id " + id + " not found"));

        admin.replaceFieldsWith(dto);

        if (dto.password() != null && !dto.password().isBlank()) {
            admin.setPassword(passwordEncoder.encode(dto.password()));
        }

        adminRepository.save(admin);
    }

    public void delete(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin with id " + id + " not found"));
        adminRepository.delete(admin);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin " + email + " not found"));

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(AUTHORITY));

        return org.springframework.security.core.userdetails.User
                .withUsername(admin.getEmail())
                .password(admin.getPassword())
                .authorities(authorities)
                .accountExpired(false)
                .credentialsExpired(false)
                .build();
    }
}

