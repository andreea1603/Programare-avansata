package com.jcg.jpa;
import javax.persistence.*;

@Entity
@Table(name="Genres")
@NamedQueries({
        @NamedQuery(name="findById",
        query = "SELECT g FROM Genres g WHERE g.id=?1"),
        @NamedQuery(name = "findByName",
        query = "SELECT g FROM Genres g WHERE g.name=?1"),
        @NamedQuery(name="findAll",
                query ="select g from Genres g" )
})
public class Genres {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}