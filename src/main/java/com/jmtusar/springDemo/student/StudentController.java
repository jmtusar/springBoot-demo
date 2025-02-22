package com.jmtusar.springDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {


    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student save(
            @RequestBody Student student
    ){
        return service.save(student);
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }

}
