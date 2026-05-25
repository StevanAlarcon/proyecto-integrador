package dev.josephalvarez.proyectointegrador.config;

import dev.josephalvarez.proyectointegrador.model.constant.NewsStatus;
import dev.josephalvarez.proyectointegrador.model.constant.Purpose;
import dev.josephalvarez.proyectointegrador.model.entity.*;
import dev.josephalvarez.proyectointegrador.model.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataSeed implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final NewsRepository newsRepository;
    private final TestimonialRepository testimonialRepository;
    private final ContactRequestRepository contactRequestRepository;

    public DataSeed(AdminRepository adminRepository,
                    PasswordEncoder passwordEncoder,
                    NewsRepository newsRepository,
                    TestimonialRepository testimonialRepository,
                    ContactRequestRepository contactRequestRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.newsRepository = newsRepository;
        this.testimonialRepository = testimonialRepository;
        this.contactRequestRepository = contactRequestRepository;
    }

    @Override
    public void run(String... args) {
        seedAdmins();
        seedNews();
        seedTestimonials();
        seedContactRequests();
    }

    private void seedAdmins() {
        if (adminRepository.count() == 0) {
            Admin admin = new Admin();
            admin.setName("Administrador");
            admin.setSurname("Ecuador Comparte");
            admin.setEmail("admin@ecuadorcomparte.org");
            admin.setPassword(passwordEncoder.encode("admin1234"));
            adminRepository.save(admin);
        }
    }

    private void seedNews() {
        if (newsRepository.count() == 0) {
            News n1 = new News();
            n1.setTitle("Nuevas becas para jóvenes en la Sierra Central");
            n1.setSummary("Iniciamos el programa 'Raíces de Futuro' beneficiando a más de 100 estudiantes.");
            n1.setContent("La Fundación Ecuador Comparte ha lanzado el programa 'Raíces de Futuro', el cual busca " +
                    "beneficiar a más de 100 jóvenes de la Sierra Central del Ecuador con herramientas digitales, " +
                    "tutorías personalizadas y acceso a formación técnica. Este programa es parte de nuestra misión " +
                    "de reducir las brechas educativas y empoderar a las nuevas generaciones.");
            n1.setImageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuDzs0xUKNe3bxUu7Jw9Uz-EFJ1Ye0ScvVBI-jUulYhVnQT3Z8Vx30BmQgZM9152CUwDEkktRKkTaSY9ASu84B1nI_ydmlu6Xoto1hrsjMeho66DSVHa5ssTS-tu8fZ-OriGSbyYjf8R-SYJpKNUz4Ttn94kqX-mORUZX5rTTgMqIZkAEssmmX7LSv5lJP6bmmkiWXIYjrZ7G819epqTosrnVGvbJUC3y2dEQM_vfW5CNiHl-ETWJpB7FZ4dG-vc5yQ_TfWE_RI0P1o");
            n1.setStatus(NewsStatus.STATE_PUBLISHED);
            n1.setPublishDate(LocalDateTime.now().minusDays(5));
            n1.setAuthor("Equipo Ecuador Comparte");
            newsRepository.save(n1);

            News n2 = new News();
            n2.setTitle("Red de Comedores Comunitarios se expande a Guayaquil");
            n2.setSummary("Inauguramos tres nuevos puntos de distribución de alimentos nutritivos.");
            n2.setContent("En un esfuerzo por combatir la inseguridad alimentaria, Ecuador Comparte inaugura tres " +
                    "nuevos comedores comunitarios en Guayaquil. Estos espacios atenderán a familias en situación " +
                    "de vulnerabilidad extrema, proporcionando alimentos nutritivos y de calidad cada día.");
            n2.setImageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuBMr0mvGx4O7ByBjA_nFiLwOJgefbliG_1XqmSLJNeZSJ7WZwrQg37hgIZ4tOEkJIApUgT6Ls0Je_iSGDAwJyIoJXoaaGo7RUMcgx9WntFL7yXlQQh80zfXa6rURpNYAqnhOETgspb9aYUREms0Vxcfrrlz2WAj2FNczB-Zx0Iph1vUJQOWn0amXRsFKoBX2jiWGRf1Dl3O0CAhe6mS2eEd_piPT8xJZdl_Bg4y3l6KZ16jLwv2vR8k84FX5T-8F74ufOinrXxFlGo");
            n2.setStatus(NewsStatus.STATE_PUBLISHED);
            n2.setPublishDate(LocalDateTime.now().minusDays(10));
            n2.setAuthor("Equipo Ecuador Comparte");
            newsRepository.save(n2);

            News n3 = new News();
            n3.setTitle("Ecuador Comparte recibe reconocimiento por transparencia");
            n3.setSummary("Nuestra gestión fue auditada y certificada con los más altos estándares.");
            n3.setContent("La Fundación Ecuador Comparte fue reconocida por AlianzaEc como una de las organizaciones " +
                    "sin ánimo de lucro con mayor transparencia en la gestión de recursos. La auditoría externa validó " +
                    "nuestros procesos financieros, la trazabilidad de las donaciones y el impacto social de nuestros programas.");
            n3.setImageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuAQ34rA_fgV30IqW-3UUUkT0LtZkN2YAkHpsrY-DkUjWRa-TjAQt1N0UNbhvdq0oCHr4xaGPPOfY40mTL4LhHQMbyCu9ydOwFYHj1OpTbtyDrDNLTIU_MdVRmXQ15ENDANekQWspoHYTdHzBq2-0_5hj_Ph2c6xIoRtad5o5v1ep93S1Dw-5W1Vade5cbsJVi9ufuPXQsP4ux0yNM_TpeE5hujbxH0lC_D1aFF7_lIBzIETfL-t-e3mJ8dp12dY");
            n3.setStatus(NewsStatus.STATE_PUBLISHED);
            n3.setPublishDate(LocalDateTime.now().minusDays(15));
            n3.setAuthor("Equipo Ecuador Comparte");
            newsRepository.save(n3);
        }
    }

    private void seedTestimonials() {
        if (testimonialRepository.count() == 0) {
            Testimonial t1 = new Testimonial();
            t1.setName("María Elena, Quito");
            t1.setPhotoUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuBnhHRMzNdY8jjrMy7_Hi8_AuabHSx-6oKjKSjvi7TaGKczfyOuEjVlAdwPhSrXThxRU-2ds3i2Yu7F_WC3lJKpzY0BQwrfPU1KqIQ5LwKYeizr70_uLTwVYBq0AIQCBWDy0vzp8HcMdxjSoTnJ65wq1XNyrEbE8tNrbrIhfthx44rdc7LOc_OtYBNqQJYU8G0zwQAWIvt62KMe8qN9HqLo8L9uTUamBOujH5XWYwpIZ3ZMQDMopLr-IY0qCH08osl6oHJZNZkyhSw");
            t1.setInstagramUrl("https://instagram.com");
            t1.setFacebookUrl("https://facebook.com");
            t1.setCreateDate(LocalDateTime.now().minusDays(20));
            testimonialRepository.save(t1);

            Testimonial t2 = new Testimonial();
            t2.setName("Juan Pérez, Guayaquil");
            t2.setPhotoUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuCWFFNBj2Mjb8eZqb7gGYqbOSbmKhG0G_Fe1W51h3WR9ZsZXgbQccmtcBAjRuMlrJTXwWf93IMur9RJKLi4hlei5tUtp1D5sj8u-gV1JxShOL_ir-CSsN7pI4WUQAVZWz9r6TdwuXs7MKn56mvbPz1yft18pm-oSwV0x253Zce5ebthjCTrHciyMQ9mpMfzjFHHEsIqyf4Sp7WU9rPdoSHmXsFEznU6FERZuHeiCFpKSwdBn-8WCEceXghU5WZIAWA-w7v_KoIRlmU");
            t2.setInstagramUrl("https://instagram.com");
            t2.setFacebookUrl("https://facebook.com");
            t2.setCreateDate(LocalDateTime.now().minusDays(25));
            testimonialRepository.save(t2);
        }
    }

    private void seedContactRequests() {
        if (contactRequestRepository.count() == 0) {
            ContactRequest cr1 = new ContactRequest();
            cr1.setName("Ana Lucía Torres");
            cr1.setEmail("ana@ejemplo.com");
            cr1.setPhoneNumber("0991234567");
            cr1.setPurpose(Purpose.SERVICIO);
            cr1.setCreateDate(LocalDateTime.now().minusDays(2));
            contactRequestRepository.save(cr1);

            ContactRequest cr2 = new ContactRequest();
            cr2.setName("Carlos Rodríguez");
            cr2.setEmail("carlos@ejemplo.com");
            cr2.setPhoneNumber("0987654321");
            cr2.setPurpose(Purpose.PROGRAMA_EDIFICA);
            cr2.setCreateDate(LocalDateTime.now().minusDays(1));
            contactRequestRepository.save(cr2);
        }
    }
}
