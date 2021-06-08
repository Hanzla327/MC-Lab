package com.hanzla.recycler.Model;

public class Student {
    String Name,RollNo;

    public Student() {
    }

    public Student(String name, String rollNo) {
        Name = name;
        RollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }
}
