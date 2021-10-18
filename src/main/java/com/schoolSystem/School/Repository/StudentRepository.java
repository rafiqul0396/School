package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long> {
public List<Student> findByfirstName(String firstName);
public List<Student> findByEmailIdContains(String emailId);
public List<Student> findByfirstNameEndingWith(String firstName);

//JPQL
@Query("select  s from Student  s where s.emailId=?1")
Student getStudentByEmailAddress(String emailId);


//JPQL
//JPQL
@Query("select  s.firstName from Student  s where s.emailId=?1")
String getStudentfirstNameByEmailAddress(String emailId);


    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);
    //Native named param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeparam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);




}



