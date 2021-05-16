package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/friendship")
public class FriendshipController {

    private final List<Friendship> friendships = new ArrayList<>();

    public FriendshipController() {
        friendships.add(new Friendship("a", "b"));

    }

    @GetMapping
    public List<Friendship> getFriendships() {
        return friendships;
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/add")
    @PostMapping("{name1}")
    public String addPerson(@RequestParam(name = "name1") String name1,
                          @RequestParam(name = "name2") String name2) {
        String sql = "insert into friendship values ('" + name1 + "', '" + name2 +"')";
        friendships.add(new Friendship(name1, name2));
        int result = jdbcTemplate.update(sql);
        if (result > 0) {
            System.out.println("adaugat");
        }
       // System.out.println(friendships);
        return "Adaugat!";
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String>
    createFriendship(@RequestBody Friendship friendship) {

        this.friendships.add(friendship);
        if (this.friendships.size() > 0) {
            System.out.println("adaugat");
        }
        return new ResponseEntity<>(
                "Product created successfully", HttpStatus.CREATED);
    }
    @GetMapping("/getConn")
    public List<String> getMostConnected(@RequestParam(name = "k") int k){
        List<String> names=new ArrayList<>();
        List<Long> times= new ArrayList<>();
        long nrApperancePerson2=0, nrApperancePerson1=0;
        List<String> distinctPersons=getDistinct(friendships);
        for( int i=0; i<distinctPersons.size(); i++) {
            nrApperancePerson2 = 0;
            nrApperancePerson1=0;
            String sql1 = " select count(person1) as maxim1 from friendship where person1='" + distinctPersons.get(i) + "'";
            String sql2 = " select count(person1) as maxim1 from friendship where person2='" + distinctPersons.get(i) + "'";

            String sql3 = " select count(person2) as maxim2 from friendship where person2='" + distinctPersons.get(i) + "'";
            String sql4 = " select count(person2) as maxim2 from friendship where person1='" + distinctPersons.get(i) + "'";

            names.add(distinctPersons.get(i));
            //names.add(friendships.get(i).getPerson2());

            Long rows1 = jdbcTemplate.queryForObject(sql1, Long.class);
            Long rows2 = jdbcTemplate.queryForObject(sql2, Long.class);

            Long rows3 = jdbcTemplate.queryForObject(sql3, Long.class);
            Long rows4 = jdbcTemplate.queryForObject(sql4, Long.class);

            nrApperancePerson2= rows1+ rows2;
            //nrApperancePerson1=rows3+ rows4;

            times.add(nrApperancePerson2);
           // times.add(nrApperancePerson1);
            System.out.println(nrApperancePerson2 + " m " + nrApperancePerson1 );
        }
        System.out.println("am iesit");
            List<String> namesFirst= getFirstK(times, names, k);
            for(int i=0; i<namesFirst.size(); i++)
                    System.out.println(namesFirst.get(i));

        return namesFirst;
    }
    public List<String> getFirstK(List<Long> times, List<String> names, int k){
        List<String> name_result=new ArrayList<>();

        for(int i=0; i< times.size()-1; i++){
            for( int j= i+1; j<times.size(); j++)
                if(times.get(i)<times.get(j)){
                    long aux = times.get(i);
                    times.set(i, times.get(j));
                    times.set(j, aux);
                    String aux1= names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, aux1);
                }
        }
        for(int i=0; i<k && i< names.size(); i++){
            name_result.add(names.get(i));
        }
        return name_result;
    }

    public List<String> getDistinct(List<Friendship> friendships){
        List<String> distinctPersons= new ArrayList<>();

        for( int i=0; i< friendships.size(); i++)
        {
            if(!distinctPersons.contains(friendships.get(i).getPerson1())){
                distinctPersons.add(friendships.get(i).getPerson1());
            }
            if(!distinctPersons.contains(friendships.get(i).getPerson2())){
                distinctPersons.add(friendships.get(i).getPerson2());
            }
        }

        return distinctPersons;
    }
}

