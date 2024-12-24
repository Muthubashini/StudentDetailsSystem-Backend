package com.inventoryStudent.studentDetailsSystem.service;

import com.inventoryStudent.studentDetailsSystem.entity.Student;
import com.inventoryStudent.studentDetailsSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createNewStudent(Student student) {

        student = new Student();

        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllBooks() {
        return studentRepository.findAll();
    }
}
