package com.jmtusar.springDemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student(
                        "JM",
                        "Tusar",
                        LocalDate.now(),
                        "jmtusar@jmt.com",
                        23),
                new Student(
                        "Alexa",
                        "Taylor",
                        LocalDate.now(),
                        "alexa@at.com",
                        33));
    }
}
