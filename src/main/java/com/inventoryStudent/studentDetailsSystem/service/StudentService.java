package com.inventoryStudent.studentDetailsSystem.service;

import com.inventoryStudent.studentDetailsSystem.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    Student createNewStudent(Student student);

    List<Student> getAllBooks();
}