package com.company.moke;
public class Service {
    private Database database;
    public Service(Database database){
        this.database=database;
    }


    public Student addStudents(Student student){
        database.addStudents(student);
        return student;
    }
    public int getSize(){
        return this.database.getDatabaseSize();
    }
    public boolean query(String query){
        return database.isAvailable();
    }



}

