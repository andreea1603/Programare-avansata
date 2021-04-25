package com.jdbc;

public class Actor {
    String name;
    int id;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Actor(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
