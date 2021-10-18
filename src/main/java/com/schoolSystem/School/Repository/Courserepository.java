package com.schoolSystem.School.Repository;

import com.schoolSystem.School.Entity.Course;
import com.schoolSystem.School.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Courserepository extends JpaRepository<Course,Long> {


}
