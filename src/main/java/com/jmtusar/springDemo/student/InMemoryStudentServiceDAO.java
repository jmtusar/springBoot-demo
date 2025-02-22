package com.jmtusar.springDemo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentServiceDAO {
    private final List<Student> STUDENT = new ArrayList<>();

    public Student save(Student s) {
        STUDENT.add(s);
        return s;
    }

    public List<Student> findAllStudents(){
        return STUDENT;
    }

    public Student findByEmail(String email) {
        return STUDENT.stream()
                .filter(s -> email.equals(s.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public Student update(Student s) {
        var studentIndex = IntStream.range(0 , STUDENT.size())
                .filter(index -> STUDENT.get(index).getEmail().equals(s.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex > -1){
            STUDENT.set(studentIndex, s);
            return s;
        }
        return null;
    }

    public void delete(String email) {
        var student = findByEmail(email);
        if(student != null){
            STUDENT.remove(student);
        }
    }
}
