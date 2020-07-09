package com.solutions.repository;

import com.solutions.proyecto.Course;
import com.solutions.proyecto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Query(value = " SELECT * FROM  Course c WHERE c.Active = 1", nativeQuery = true)
    List<Course> coursesActive();

}
