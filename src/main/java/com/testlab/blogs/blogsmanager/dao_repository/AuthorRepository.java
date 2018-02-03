package com.testlab.blogs.blogsmanager.dao_repository;

import com.testlab.blogs.blogsmanager.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{
}
