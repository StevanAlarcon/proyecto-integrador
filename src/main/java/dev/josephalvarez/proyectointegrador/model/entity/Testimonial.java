package dev.josephalvarez.proyectointegrador.model.entity;

import dev.josephalvarez.proyectointegrador.model.dto.TestimonialDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "testimonial")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testimonialId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 500)
    private String photoUrl;

    @Column(nullable = false, length = 500)
    private String instagramUrl;

    @Column(nullable = false, length = 500)
    private String facebookUrl;

    @Column(nullable = false)
    private LocalDateTime createDate;

    public Testimonial() {}

    public Long getTestimonialId() {return testimonialId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPhotoUrl() {return photoUrl;}

    public void setPhotoUrl(String photoUrl) {this.photoUrl = photoUrl;}

    public String getInstagramUrl() {return instagramUrl;}

    public void setInstagramUrl(String instagramUrl) {this.instagramUrl = instagramUrl;}

    public String getFacebookUrl() {return facebookUrl;}

    public void setFacebookUrl(String facebookUrl) {this.facebookUrl = facebookUrl;}

    public LocalDateTime getCreateDate() {return createDate;}

    public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}

    public void replaceFields(TestimonialDTO testimonialDTO) {
        setName(testimonialDTO.name());
        setPhotoUrl(testimonialDTO.photoUrl());
        setFacebookUrl(testimonialDTO.FacebookUrl());
        setInstagramUrl(testimonialDTO.InstagramUrl());
        setCreateDate(testimonialDTO.createDate());
    }
}



