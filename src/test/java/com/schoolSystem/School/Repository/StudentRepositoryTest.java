package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Guardian;
import com.schoolSystem.School.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

        /**
         *
         */
        @Autowired
        private  StudentRepository studentsRepo;
        @Test
        public  void saveStudent(){
            Student student;
            student = Student
                    .builder()
                    .emailId("rafiqul.@gmail.com").
                    firstName("rafiqul").
                    lastName("islam")
                    //.gurdianEmail("abdul@gmail.com").
                    //gurdianName("abdul halim").
                   // gurdianMobileNo("9365193737")
                    .build();
            studentsRepo.save(student);

        }
        @Test
        public  void saveAllSrudentGuradian(){
            Guardian guardian=Guardian.builder()
                    .email("abdul@gmail.com")
                    .mobileNo("9717803085")
                    .name("abdul karim").build();
            Student student=Student.builder()
                    .firstName("aakash").lastName("sharma").emailId("aakash@gmail.com").guardian(guardian).build();
          studentsRepo.save(student);
        }


        @Test
        public  void printStudentByfirstName(){
            List<Student>student=
            studentsRepo.findByfirstName("rafiqul");
            System.out.println("student = " + student);
        }


        @Test
        public void  findByEmailIdContainsallmail(){
            List<Student>student=studentsRepo.findByEmailIdContains("rafiqul.@gmail.com");
            System.out.println("student = " + student);
        }
        @Test
        public  void printGetEmailAddress(){
            Student student=studentsRepo.getStudentByEmailAddress("aakash@gmail.com");
            System.out.println("student = " + student);
        }
       @Test
        public  void  printGetfirstNameEmailAddress(){
            String firstName=studentsRepo.getStudentfirstNameByEmailAddress("aakash@gmail.com");
            System.out.println("firstName = " + firstName);
        }
 @Test
 public  void  printAllStudent(){
            List<Student> allStudent=studentsRepo.findAll();
     System.out.println("allStudent = " + allStudent);
 }




    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentsRepo.getStudentByEmailAddressNative(
                        "aakash@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public  void printGetStudentByEmailAddressNativeParam(){
        Student student =
                studentsRepo.getStudentByEmailAddressNative(
                        "aakash@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest() {
        studentsRepo.updateStudentNameByEmailId(
                "sarwar alam",
                "rafiqul.@gmail.com");
    }

}