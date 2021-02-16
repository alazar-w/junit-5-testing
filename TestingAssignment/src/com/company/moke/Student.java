package com.company.moke;
public class Student {

    private String firstName;
    private String lastName;
    private int Age;
    private String department;

    Student(String firstname, String lastName, int Age, String department){
        this.firstName=firstname;
        this.lastName=lastName;
        this.Age=Age;
        this.department=department;
    }

    public String getFullName(){
        return this.firstName + " " +this.lastName;
    }


}
