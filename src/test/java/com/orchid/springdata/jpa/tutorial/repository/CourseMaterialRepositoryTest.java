package com.orchid.springdata.jpa.tutorial.repository;

import com.orchid.springdata.jpa.tutorial.entity.Course;
import com.orchid.springdata.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository repository;


    @Test
    public void SaveCourseMaterial(){
        //Création de l'objet course
        Course course=
                Course.builder()
                        .title("DOTNET")
                        .credit(6)
                        .build();


       CourseMaterial courseMaterial=
               CourseMaterial.builder()
                .url("www.gmail.com")
                .course(course)
                .build();

       repository.save(courseMaterial);
    }

@Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=
                repository.findAll();
        System.out.println("list of course materials"+courseMaterials);

    }




}