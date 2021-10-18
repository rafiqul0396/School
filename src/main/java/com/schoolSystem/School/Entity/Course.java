package com.schoolSystem.School.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
// bi directional oneto one mapping
    @OneToOne(
            //the corse mapping with courseMaterial
            mappedBy = "course"
    )
    private  CourseMaterial coursematerial;

    //many to one relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private  Teacher teacher;


    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "Student_course_mapping",
            joinColumns = @JoinColumn(
                    name ="corse_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "Student_id",
                    referencedColumnName = "StudentId"
            )
    )
    private List<Student> students;


    public void AddStudent(Student student){
        if(students==null){
            students=new ArrayList<>();
            students.add(student);
        }
    }

}
