package com.example.demo.repository;

import com.example.demo.domain.ImageObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(ImageObject product) {
        em.persist(product);
    }

    // JPQL
}
