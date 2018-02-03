package com.testlab.blogs.blogsmanager.dao_repository;

import com.testlab.blogs.blogsmanager.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<BlogEntity, UUID> {
}
