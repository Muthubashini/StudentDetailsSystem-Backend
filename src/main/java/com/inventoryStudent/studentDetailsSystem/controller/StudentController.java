package com.inventoryStudent.studentDetailsSystem.controller;

import com.inventoryStudent.studentDetailsSystem.entity.Student;
import com.inventoryStudent.studentDetailsSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student) {

        try{
            Student createStudent = studentService.createNewStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // endpoint to get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> books = studentService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    // New endpoint: Get student by code
    @GetMapping("/getByCode")
    public ResponseEntity<Student> getStudentByCode(@Param("student_code") String student_code) {
        return studentService.getStudentDetailsByCode(student_code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
