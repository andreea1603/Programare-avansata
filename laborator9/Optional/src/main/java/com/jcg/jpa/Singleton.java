package com.jcg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class Singleton {
    public static Singleton s1=null;
    public static EntityManagerFactory emFactoryObj = null;

    private Singleton(){
         String PERSISTENCE_UNIT_NAME = "Compulsory9";
         emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager entityMgr =emFactoryObj.createEntityManager();
        entityMgr.getTransaction().begin();

    }
    public static Singleton getInstance()
    {
        if(s1==null)
            s1=new Singleton();
        return s1;
    }

}
