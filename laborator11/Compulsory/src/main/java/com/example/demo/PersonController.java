package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final List<Person> person = new ArrayList<>();
    public PersonController() {
        person.add(new Person("a"));

    }
    @GetMapping
    public List<Person> getProducts() {
        return person;
    }
    @GetMapping("/count")
    public int countProducts() {
        return person.size();
    }

    @GetMapping("/{id}")
    public Person getProduct(@PathVariable("id") String id) {
        for (Person p : person) {
            if (p.getName().compareTo(id)==0) {
                return p;
            }
        }
        return null;
    }



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public void addPerson(@RequestParam String name){
        String sql="insert into person values ('"+ name + "')";
        person.add(new Person(name));
        int result=jdbcTemplate.update(sql);
        if(result>0){
            System.out.println("adaugat");
        }
    }
    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createPerson(@RequestBody Person person) {

        this.person.add(person);
        if(this.person.size()>0){
            System.out.println("adaugat");
        }
        return new ResponseEntity<>(
                "Product created successfully", HttpStatus.CREATED);
    }


        @PutMapping("/{id}")
        public ResponseEntity<String> updatePerson(
                @PathVariable String name, @RequestParam String nameC) {
            Person person = findPerson(name);
            if (person == null) {
                return new ResponseEntity<>(
                        "Product not found", HttpStatus.NOT_FOUND); //or GONE
            }
            person.setName(name);
            return new ResponseEntity<>(
                    "Product updated successsfully", HttpStatus.OK);
        }

        Person findPerson(String name){
        for(int i=0; i<person.size(); i++)
            if(person.get(i).name.compareTo(name)==0)
                return person.get(i);
        return null;
        }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        Person person = findPerson(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.GONE);
        }
        this.person.remove(person);
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }



}
