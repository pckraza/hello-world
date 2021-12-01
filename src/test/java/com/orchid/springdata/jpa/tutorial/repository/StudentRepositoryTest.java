package com.orchid.springdata.jpa.tutorial.repository;

import com.orchid.springdata.jpa.tutorial.entity.Guardian;
import com.orchid.springdata.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
     private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
    Student student= Student.builder()
            .emailId("alex@orchid.mg")
            .firstName("alex")
            .lastName("razafintsalama")
            //.guardianName("nadia")
            //.guardianEmail("nadia@gmail.com")
            //.guardianMobile("0347237243")
            .build();
    studentRepository.save(student);
    }

@Test
    public void saveStudentWithGuardian(){
        //Construction d'un objet guardian
        Guardian guardian=Guardian.builder()
                .name("nadia")
                .email("nadia@orchid.mg")
                .mobile("0344612117")
                .build();

        //Construction d'un objet student
        Student student=Student.builder()
                .emailId("tracy@gmail.com")
                .firstName("Tracy")
                .lastName("razafintsalama")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
            List<Student> students=studentRepository.findAll();
            System.out.println("student list"+students);

        }

        @Test
        public void findStudentByFirstName()
        {
            List<Student> students=studentRepository.findStudentByFirstName("alex");
            System.out.println("students="+students);


        }

        @Test
    public void findStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findStudentByFirstNameContaining("t");
            System.out.println("students="+students);
        }
        @Test
        public  void findStudentByLastNameNotNull(){
        List<Student> students=studentRepository.findStudentByLastNameNotNull();
        }
        @Test//Recherche par le nom du Guardian qui est embedded dans la classe Student
        public void findByGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("nadia");
            System.out.println("Student="+students);
        }

        @Test//Recherche par FirstName ET LastName
        public void findByFirstNameAndLastName(){
          List<Student> students=studentRepository.findByFirstNameAndLastName("alex","razafintsalama");
    }






}