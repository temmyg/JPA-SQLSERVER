package com.testlab.blogs.blogsmanager.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Blog")
public class BlogEntity {

    private String title;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = AuthorEntity.class)  //
    @JoinColumn(name = "authorId", referencedColumnName = "Id")
    private AuthorEntity author;

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

