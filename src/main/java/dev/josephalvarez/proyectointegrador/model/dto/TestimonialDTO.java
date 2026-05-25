package dev.josephalvarez.proyectointegrador.model.dto;

import dev.josephalvarez.proyectointegrador.model.entity.Testimonial;

import java.time.LocalDateTime;

public record TestimonialDTO(
        String name,
        String photoUrl,
        String InstagramUrl,
        String FacebookUrl,
        LocalDateTime createDate
) {
    public Testimonial toEntity() {
        Testimonial testimonial = new Testimonial();

        testimonial.setName(name);
        testimonial.setPhotoUrl(photoUrl);
        testimonial.setInstagramUrl(InstagramUrl);
        testimonial.setFacebookUrl(FacebookUrl);
        testimonial.setCreateDate(createDate);

        return testimonial;
    }
}
