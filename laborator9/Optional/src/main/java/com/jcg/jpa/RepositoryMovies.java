package com.jcg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepositoryMovies implements Repository{
    @Override
    public void create(int id, String title, EntityManager entityMrg) {
        Movies movies=new Movies();
        entityMrg.getTransaction().begin();

        movies.setId(id);
        movies.setName(title);
       // movies.setDuration(duration);
        entityMrg.persist(movies);
        entityMrg.getTransaction().commit();

    }

    @Override

    public Movies findById(EntityManager entityMgr, int id) {
        entityMgr.getTransaction().begin();
        Query query=entityMgr.createNamedQuery("findByIdM");
        query.setParameter(1, id);
        Movies g1=(Movies)query.getSingleResult();
        entityMgr.getTransaction().commit();

        return g1;
    }

    @Override
    public List<Movies> findByName(EntityManager entityMgr, String name) {
        Query query1=entityMgr.createNamedQuery("findByNameM");
        query1.setParameter(1, name);
        List<Movies> g2=new ArrayList<>();
        g2=query1.getResultList();
        return g2;

    }
}

