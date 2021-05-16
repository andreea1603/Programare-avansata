package com.example.demo;

public class Friendship {
    String person1;
    String Person2;

    public Friendship(String person1, String person2) {
        this.person1 = person1;
        Person2 = person2;
    }

    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
        this.person1 = person1;
    }

    public String getPerson2() {
        return Person2;
    }

    public void setPerson2(String person2) {
        Person2 = person2;
    }
}
