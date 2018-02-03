package com.testlab.blogs.blogsmanager;

import com.testlab.blogs.blogsmanager.dao_repository.AuthorRepository;
import com.testlab.blogs.blogsmanager.dao_repository.BlogRepository;
import com.testlab.blogs.blogsmanager.entities.AuthorEntity;
import com.testlab.blogs.blogsmanager.entities.BlogEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class BlogsManagerApplication implements CommandLineRunner{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BlogRepository blogRepo;

	@Autowired
	AuthorRepository authRepo;

	@Autowired
	EntityManagerFactory emf;

	public static void main(String[] args) {
		SpringApplication.run(BlogsManagerApplication.class, args);
	}

	public void run(String... args){
		List<BlogEntity> blogs = blogRepo.findAll();
		List<AuthorEntity> authors = authRepo.findAll();

		EntityManager em = emf.createEntityManager();
		List<BlogEntity> blogs2 = em.createQuery("select b from BlogEntity b", BlogEntity.class).getResultList();


		em.getTransaction().begin();
		blogs2.get(0).setTitle("the fire is dimmed");
		em.getTransaction().commit();
		Session seesion = em.unwrap(Session.class);
	}

}
