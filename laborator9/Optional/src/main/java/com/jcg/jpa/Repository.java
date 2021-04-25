package com.jcg.jpa;

import javax.persistence.EntityManager;
import java.util.List;

public interface Repository<T> {
    void create(int id, String title, EntityManager entityManager);
    T findById(EntityManager entityManager, int id);
    List<T> findByName(EntityManager entityManager, String name);

}
