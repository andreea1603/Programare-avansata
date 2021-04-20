import javax.persistence.*;
import java.io.Serializable;

public class Compulsory9 {
    public static void main(String[] args) {

        EntityManagerFactory emf=
                Persistence.createEntityManagerFactory("MyApplication");
        EntityManager em= emf.createEntityManager();

        em.getTransaction().begin();
        Genres p= new Genres();
        p.setId(3);
        p.setName("stata");

        //System.out.println(p.getId());
        em.persist(p);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }


}
