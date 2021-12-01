package com.orchid.springdata.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
   @Id
   @SequenceGenerator(
           name = "course_material_sequence",
           sequenceName = "course_material_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator ="course_material_sequence"

   )
   private Long courseMaterialId;
   private String url;


   @OneToOne (
           cascade = CascadeType.ALL,
           fetch = FetchType.LAZY,
           optional = false
   )
   @JoinColumn(
           name = "course_id",
           referencedColumnName = "courseId"//fait référence à la clé primaire de la classe Course

   )
   private Course course;
}
