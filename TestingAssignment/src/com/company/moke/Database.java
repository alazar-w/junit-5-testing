package com.company.moke;
import java.util.ArrayList;

public class Database {

    public static ArrayList<Student> students= new ArrayList<>();

    public int getDatabaseSize(){
        return this.students.size();
    }
    public Student addStudents(Student student){
        this.students.add(student);
        return student;
    }
    public boolean isAvailable(){
        return true;
    }
















}
