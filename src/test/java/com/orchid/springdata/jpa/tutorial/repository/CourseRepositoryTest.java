package com.orchid.springdata.jpa.tutorial.repository;

import com.orchid.springdata.jpa.tutorial.entity.Course;
import com.orchid.springdata.jpa.tutorial.entity.Student;
import com.orchid.springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("liste des cours"+courses);
    }

@Test
//Enregister un cours avec prof
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("Cedric")
                .lastName("Razafintsalama")
                .build();

        Course course=Course.builder()
                .title("Python")
                .credit(12)
                .teacher(teacher)
                .build();



        courseRepository.save(course);
}
    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords= PageRequest.of(1,3);
        PageRequest secondPageWithTwoRecords= PageRequest.of(1,2);


        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements=courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("total pages="+totalPages);
        System.out.println("total elements="+totalElements);
        System.out.println("courses="+courses);

    }
    @Test
    public void finALLSorting(){
        Pageable sortByTitle=PageRequest.of(
                0,
                2,
                Sort.by("Title")
        );
        Pageable sortByCreditDesc=PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc=PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Liste des cours par ordre décroissant des titres"+courses);

        List<Course> coursesParCredit=courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("Liste des cours par ordre décoissant des crédits"+coursesParCredit);
    }
@Test
    public void printByTitleContaining(){
        Pageable firstPageTenPages=PageRequest.of(0, 10);

        List<Course> coursesContainingTitle=courseRepository.findByTitleContaining(
                "D",
                firstPageTenPages).getContent();
        System.out.println("courses whose title contain"+coursesContainingTitle);
    }

@Test
    public void saveCourseWithTeacherAndStudent(){
        Teacher teacherA= Teacher
                .builder()
                .firstName("essai")
                .lastName("essai")
                .build();

         Student studentA= Student
                .builder()
                .firstName("etud1")
                .lastName("ETUD1")
                .emailId("éty@gmail.com")
                .build();

    Student studentB= Student
            .builder()
            .firstName("étud2")
            .lastName("étut2")
            .emailId("etud@gmail.com")
            .build();



        Course course= Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacherA)
                .build();
        course.addSttudent(studentA);
        course.addSttudent(studentB);


        courseRepository.save(course);

    }

    }



