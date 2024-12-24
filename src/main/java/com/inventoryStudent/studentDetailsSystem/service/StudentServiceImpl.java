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

    @Override
    public Optional<Student> getStudentDetailsByCode(String student_code) {
        return studentRepository.findByStudent_code(student_code);
    }

    @Override
    @Transactional
    public Student updateStudentByCode(String student_code, Student updatedStudent) {
        return studentRepository.findByStudent_code(student_code).map(existingStudent -> {
            existingStudent.setStudent_name(updatedStudent.getStudent_name());
            existingStudent.setStudent_age(updatedStudent.getStudent_age());
            existingStudent.setStudent_nic(updatedStudent.getStudent_nic());
            existingStudent.setHome_town(updatedStudent.getHome_town());
            return studentRepository.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student with code " + student_code + " not found"));
    }

    @Override
    @Transactional
    public Optional<Student> deleteStudentByCode(String student_code) {
        return studentRepository.findByStudent_code(student_code).map(student -> {
            studentRepository.delete(student);
            return student;
        });
    }
}
