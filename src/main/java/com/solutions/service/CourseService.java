package com.solutions.service;

import com.solutions.proyecto.Course;
import com.solutions.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> listAll(){

        return repo.findAll();
    }

    public List<Course> coursesActive(){

        return repo.coursesActive();
    }

    public void save(Course course){
        repo.save(course);
    }

    public Course get(int courseId){
        return repo.findById(courseId).get();
    }

    public void delete(int courseId){
        repo.deleteById(courseId);
    }

    public void update(Course entity) {
        Course entityToUpdate = repo.findById(entity.getCourseId()).get();
        if(entityToUpdate != null) {
//            entity.setPass(entityToUpdate.getPass());
            repo.save(entity);
        }
    }
}
