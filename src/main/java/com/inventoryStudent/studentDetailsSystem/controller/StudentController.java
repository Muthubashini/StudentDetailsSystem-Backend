package com.inventoryStudent.studentDetailsSystem.controller;

import com.inventoryStudent.studentDetailsSystem.entity.Student;
import com.inventoryStudent.studentDetailsSystem.repository.StudentRepository;
import com.inventoryStudent.studentDetailsSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    // New endpoint: Create new student
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {

        try{
            Student createStudent = studentService.createNewStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // New endpoint: Get all students details
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

    // New endpoint: Update student by code
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudentByCode(
            @Param("student_code") String student_code,
            @RequestBody Student updatedStudent) {
        try {

            Student updated;
            updated = studentService.updateStudentByCode(student_code, updatedStudent);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // New endpoint: delete student by code
    @DeleteMapping("/delete/{student_code}")
    public ResponseEntity<String> deleteStudentByCode(@PathVariable String student_code) {
        Optional<Student> student = studentService.deleteStudentByCode(student_code);
        if (student.isPresent()) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with code " + student_code + " not found");
        }
    }

}
