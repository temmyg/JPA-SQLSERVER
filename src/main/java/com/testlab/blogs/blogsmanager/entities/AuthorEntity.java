package com.testlab.blogs.blogsmanager.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Author")
public class AuthorEntity {

    private String firstName;

    private String lastName;

    private Set<BlogEntity> blogs;

    @OneToMany(targetEntity = BlogEntity.class, fetch = FetchType.EAGER, mappedBy = "author")
    public Set<BlogEntity> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<BlogEntity> blogs) {
        this.blogs = blogs;
    }


    private long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
