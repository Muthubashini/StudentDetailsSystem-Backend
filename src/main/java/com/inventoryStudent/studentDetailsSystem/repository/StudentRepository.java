package com.inventoryStudent.studentDetailsSystem.repository;

import com.inventoryStudent.studentDetailsSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student WHERE student_code=:student_code", nativeQuery = true)
    Optional <Student> findByStudent_code(@Param("student_code") String student_code);


//    @Query(value = "SELECT * FROM student s WHERE s.date=:date", nativeQuery = true)
//    Optional <Student> studentReportByDate(@Param("date") String date);

}
