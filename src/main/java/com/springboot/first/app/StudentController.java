package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Emine", "Yazan");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Elvin", "Yazan"));
        students.add(new Student("Büşra", "Yazan"));
        students.add(new Student("Betül", "Yazan"));
        students.add(new Student("Yusuf", "Yazan"));
        return students;

    }

    //http://localhost:8080/student/{firstName}/{lastName}
    // @PathVariable annotation
    @GetMapping("/students/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    //buid rest API to handle query parameters
    //http://localhost:8080/student?firstName=Selman&lastName=Yazan
    @GetMapping("/studentparam")
    public Student studentQueryParam(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return new Student(firstName, lastName);
    }

}
