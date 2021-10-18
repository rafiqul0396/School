package com.schoolSystem.School.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_Material_sequence",
            sequenceName = "course_Material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_Material_sequence"
    )
    private  Long courseMaterilId;
    private  String  url;

// cascade data in the table
    //feaching two types LAZY and Eager
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    //unidirectional one to one mapping
    private Course course;

}
