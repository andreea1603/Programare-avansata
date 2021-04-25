package com.jcg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepositoryGenres implements Repository {
    @Override
    public void create(int id, String gen, EntityManager entityMrg) {
        Genres genres=new Genres();
        entityMrg.getTransaction().begin();

        genres.setId(id);
        genres.setName(gen);
        entityMrg.persist(genres);
        entityMrg.getTransaction().commit();

    }
    @Override
    public Genres findById(EntityManager entityMgr, int id) {
        entityMgr.getTransaction().begin();
        Query query=entityMgr.createNamedQuery("findById");
        query.setParameter(1, id);
        Genres g1=(Genres)query.getSingleResult();
        entityMgr.getTransaction().commit();

        return g1;
    }

    @Override
    public List<Genres> findByName(EntityManager entityMgr, String name) {
        Query query1=entityMgr.createNamedQuery("findByName");
        query1.setParameter(1, name);
        List<Genres> g2=new ArrayList<>();
        g2=query1.getResultList();
        return g2;

    }
}
