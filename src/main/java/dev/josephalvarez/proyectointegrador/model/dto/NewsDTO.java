package dev.josephalvarez.proyectointegrador.model.dto;

import dev.josephalvarez.proyectointegrador.model.constant.NewsStatus;
import dev.josephalvarez.proyectointegrador.model.entity.News;

import java.time.LocalDateTime;

public record NewsDTO(
        String title,
        String summary,
        String content,
        String imageUrl,
        NewsStatus status,
        LocalDateTime publishDate,
        String author
) {
    public News toEntity() {
        News news = new News();

        news.setTitle(title);
        news.setSummary(summary);
        news.setContent(content);
        news.setImageUrl(imageUrl);
        news.setStatus(status);
        news.setPublishDate(publishDate);
        news.setAuthor(author);

        return news;
    }
}
