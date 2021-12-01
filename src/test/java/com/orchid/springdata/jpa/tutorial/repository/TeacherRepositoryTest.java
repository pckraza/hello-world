package com.orchid.springdata.jpa.tutorial.repository;

import com.orchid.springdata.jpa.tutorial.entity.Course;
import com.orchid.springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveTeacher(){
        //Création d'une liste de cours à injecter dans la méthode courses() de l'objet ci-dessous
        // List<Course> coursesList = new ArrayList<>();
         Course courseFinance=Course.builder()
                 .title("FINANCE")
                 .credit(11)
                 .build();
        //coursesList.add(courseFinance);
        Course courseMarketing=Course.builder()
                .title("Marketing")
                .credit(6)
                .build();
        //coursesList.add(courseMarketing);

        //Création d'un objet de type Teacher

        Teacher teacher=Teacher.builder()
                .firstName("Karen")
                .lastName("Razafimahefa")
                //.courses(coursesList) ( car l'ajout de course se fait à partir de COURSE
                .build();
        teacherRepository.save(teacher);

            }




}