package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Course;
import com.schoolSystem.School.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

@Test
    public  void saveCourseMerial(){
        Course course=Course.builder()
                .title("DSA").credit(6).build();
        CourseMaterial courseMaterial=CourseMaterial.builder().url("www.google.com").course(course).build();

        courseMaterialRepository.save(courseMaterial);
    }

@Test
    public void printAllListOfCourseMaterial(){
        List<CourseMaterial> courseMetial=courseMaterialRepository.findAll();
        System.out.println("courseMetial = " + courseMetial);
    }


}