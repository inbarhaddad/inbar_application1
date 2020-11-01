package com.example.inbar_application1.model;

public class User {


    private String name;
    private String lastNAme;


    public User(String name,String lastName ) {
        this.name = name;
        this.lastNAme = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }
}
