package com.kartikd.blc;

public class Patient {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int age;
    private String gender;

    //setter: updating/mutating the values to the variables
    public Patient(String name, String gender, int age) {
        this.id = ++idCounter;  //pre-incrementation: first increment and then assign
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //getters: getting/accessing the values inside the variables
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //Overriding the toString method so that whenever we print the attributes, the value will be printed and not the hashcode
    @Override
    public String toString() {
        return "Patient ID: " + id + " , Name: " + name + " , Gender" + gender + " , Age: " + age;
    }


}
