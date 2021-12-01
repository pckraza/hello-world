package com.orchid.springdata.jpa.tutorial.Controllers;

import com.orchid.springdata.jpa.tutorial.entity.Student;
import com.orchid.springdata.jpa.tutorial.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {
    //Injection de studentRepository dans le Constructeur
    private StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping(value = "/students/{firstname}/{lastname}")
    public void findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName)
        {
        studentRepository.findByFirstNameAndLastName(firstName,lastName);


    }


}
