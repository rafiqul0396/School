package com.schoolSystem.School.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_Student",
uniqueConstraints = @UniqueConstraint(
        name="emailId_unique",
        columnNames = "email_address"
)
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_Sequence",
            sequenceName = "student_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_Sequence"
    )
    private  Long StudentId;
    private  String firstName;
    private  String lastName;
    @Column(name = "Email_Address",
    nullable = false)
    private  String emailId;
    @Embedded
   private  Guardian guardian;
}
