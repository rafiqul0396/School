package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Course;
import com.schoolSystem.School.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private  TeacherRepository teacherRepository;


    @Test
    public  void  saveTeacher(){

        Course course=Course.builder()
                .title("SpringBoot").credit(10).build();
        Course course2=Course.builder()
                .title("Jira").credit(7).build();
        Course course3=Course.builder()
                .title("Confluence").credit(5).build();
        Teacher teacher=Teacher.builder()
                .firstName("Neeraj").lastName("arora")//.courses(List.of(course,course2,course3))
                 .build();
        teacherRepository.save(teacher);
    }

}