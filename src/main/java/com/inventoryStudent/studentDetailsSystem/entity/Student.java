package com.inventoryStudent.studentDetailsSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@RequiredArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "student_code" , unique = true, nullable = false)
    private String student_code;

    @Column(name="student_name")
    private String student_name;

    @Column(name="student_age")
    private int student_age;

    @Column(name="student_nic")
    private String student_nic;

    @Column(name="home_town")
    private String home_town;

    public void setId(long id) {
        this.id = id;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    public void setStudent_nic(String student_nic) {
        this.student_nic = student_nic;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public long getId() {
        return id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_age() {
        return student_age;
    }

    public String getStudent_nic() {
        return student_nic;
    }

    public String getHome_town() {
        return home_town;
    }

    public Student() {
    }

    public Student(String student_code, String student_name, int student_age, String student_nic, String home_town) {
        this.student_code = student_code;
        this.student_name = student_name;
        this.student_age = student_age;
        this.student_nic = student_nic;
        this.home_town = home_town;
    }


}
