package com.orchid.springdata.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName ="course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="course_sequence"
    )
    private long courseId;
    private String title;
    private Integer  credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


//Pour signifier qu'un COURSE est enseigné par un TEACHER
 @ManyToOne(
         cascade = CascadeType.ALL//afin de propager une action aux entités liées
 )
 @JoinColumn(
        name = "teacher_id",
        referencedColumnName = "teacherId"
)
    private Teacher teacher;

 //Pour dire qu'un cours est suivi par pluseieurs étudiants

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"),

            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId")
    )


    private List<Student> students;

    public void addSttudent(Student student){
        //if(student == null)
        students=new ArrayList<>();
         students.add(student);
          };




}
