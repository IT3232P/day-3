package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentController {
    Student st1 = new Student("2020ict999", "John", 25, "IT", 3.4);
    Student st2 = new Student("2020ict1000", "Doe", 27, "CS", 4.0);
    Student st3 = new Student("2020ict1001", "Kholi", 24, "IT", 3.20);
    Student st4 = new Student("2020ict1002", "Tom", 28, "IT", 3.50);

    List<Student> students = new ArrayList<Student>();

    @GetMapping("/student/getAllStudents")
    public List<Student> getAllStudents() {
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        return students;
    }

    @GetMapping("/student/getStudentByRegNo/{regNo}")
    public Student getStudentByRegNo(@PathVariable String regNo) {
        for (Student student : students) {
            if (student.getRegNo().equals(regNo)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/student/getStudentByName/{name}")
    public Student getStudentByName(@PathVariable String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/student/getStudentByCourse/{course}")
    public List<Student> getStudentByCourse(@PathVariable String course) {
        List<Student> studentsByCourse = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse().equals(course)) {
                studentsByCourse.add(student);
            }
        }
        return studentsByCourse;
    }
}
