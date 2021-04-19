import javax.persistence.EntityManager;

public class Dao {
    Genres findById(int id, EntityManager em){
        Genres gen= (Genres)em.find(Genres.class, id);
        return gen;
    }
    Genres findByName(String name, EntityManager em){
        Genres gen=(Genres) em.createNamedQuery("genres.findByName");
        return gen;
    }
}
