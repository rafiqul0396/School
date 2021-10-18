package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Course;
import com.schoolSystem.School.Entity.Student;
import com.schoolSystem.School.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class CourserepositoryTest {


    @Autowired
   private  Courserepository courserepository;
@Test
    public void printCourse(){
        List<Course> course=courserepository.findAll();
        System.out.println("course = " + course);
    }

    @Test
    public void SaveteacherWithCourse(){
        Teacher teacher=Teacher.builder().firstName("varun sir").lastName("singh").build();
    Course course = Course.builder()
            .title("JPA Course").credit(12).teacher(teacher).build();
    courserepository.save(course);
    }

    @Test
    public void findAllPaging() {
        PageRequest firstPageWithfourRecords =
                PageRequest.of(0, 4);
        PageRequest secondPageWithTwoRecords =
                PageRequest.of(1, 2);
        List<Course> courses = courserepository.findAll(secondPageWithTwoRecords).getContent();
        System.out.println("courses = " + courses);

        long totalElement = courserepository.findAll(secondPageWithTwoRecords).getTotalElements();
        System.out.println("totalElement = " + totalElement);


        long totalpages = courserepository.findAll(firstPageWithfourRecords).getTotalPages();
        System.out.println("totalpages = " + totalpages);


    }

        /// testing many to many reletionship
    @Test
        public void saveCourseWithStudenAndTeacher(){
            Teacher teacher =Teacher.builder().firstName("rafiqul").lastName("islam").build();
            Course course=Course.builder()
                    .title("hibernate").credit(6).teacher(teacher).build();
            Student student=Student.builder().firstName("joheb").lastName("dani").emailId("jaheb@gmail.com").build();
            course.AddStudent(student);
            courserepository.save(course);
        }





    }