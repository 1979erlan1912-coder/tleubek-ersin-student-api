package com.example.student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<String> students = new ArrayList<>();

    public String createStudent(String name) {
        students.add(name);
        return "Student " + name + " added successfully.";
    }

    public List<String> getAllStudents() {
        return students;
    }
}
