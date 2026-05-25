package dev.josephalvarez.proyectointegrador.model.entity;

import dev.josephalvarez.proyectointegrador.model.constant.NewsStatus;
import dev.josephalvarez.proyectointegrador.model.dto.NewsDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 200)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String summary;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false,length = 500)
    private String imageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NewsStatus status;

    @Column(nullable = false)
    private LocalDateTime publishDate;

    @Column(nullable = false, length = 100)
    private String author;

    public News() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public NewsStatus getStatus() {
        return status;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public void replaceFieldsWith(NewsDTO newsDTO, NewsStatus newsStatus){
        setTitle(newsDTO.title());
        setSummary(newsDTO.summary());
        setContent(newsDTO.content());
        setImageUrl(newsDTO.imageUrl());
        setStatus(newsStatus);
        setPublishDate(newsDTO.publishDate());
        setAuthor(newsDTO.author());
    }
}
