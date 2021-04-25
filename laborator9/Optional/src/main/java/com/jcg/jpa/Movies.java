package com.jcg.jpa;
import javax.persistence.*;

@Entity
@Table(name="Movies")
@NamedQueries({
        @NamedQuery(name="findByIdM",
                query = "SELECT g FROM Movies g WHERE g.id=?1"),
        @NamedQuery(name = "findByNameM",
                query = "SELECT g FROM Movies g WHERE g.name=?1"),
        @NamedQuery(name="findAllM",
                query ="select g from Movies g" )
})
public class Movies {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String name;

    @Column(name ="duration")
    private int duration;


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
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}


