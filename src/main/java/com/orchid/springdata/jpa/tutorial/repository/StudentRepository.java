package com.orchid.springdata.jpa.tutorial.repository;

import com.orchid.springdata.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //Exemples de requêtes standards dans JPARepository
    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByFirstNameContaining(String name);
    List<Student> findStudentByLastNameNotNull();
    List<Student>findByGuardianName(String name);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);



}
