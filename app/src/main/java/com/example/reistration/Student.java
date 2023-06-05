package com.example.reistration;

public class Student {
    private String name;
    private String email;
    private boolean lastYear;
    private String gender;

    public Student(String name, String email, boolean lastYear, String gender) {
        this.name = name;
        this.email = email;
        this.lastYear = lastYear;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLastYear() {
        return lastYear;
    }

    public void setLastYear(boolean lastYear) {
        this.lastYear = lastYear;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
