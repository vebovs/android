package com.example.friends;

public class Friend {
    private String name;
    private String birthdate;

    public Friend(String name, String birthdate){
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName(){
        return this.name;
    }

    public String getBirthdate(){
        return this.birthdate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }
}
