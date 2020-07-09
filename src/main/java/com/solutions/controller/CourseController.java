package com.solutions.controller;

import com.solutions.converter.CourseConverter;
import com.solutions.proyecto.Course;
import com.solutions.dto.CourseDTO;
import com.solutions.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService service;

    @Autowired
    private CourseConverter converter;

    @GetMapping("/api/courses")
    public List<Course> list(){
        return service.listAll();
    }

    @RequestMapping(path = "/api/courses/add", method = RequestMethod.POST)
    public void save(@RequestBody CourseDTO dto) throws ParseException {
        Course entity = converter.toEntity(dto);
        System.out.println(entity.toString());
       service.save(entity);
    }

    @DeleteMapping("/api/courses/delete/{courseId}")
    public void delete(@PathVariable Integer courseId){
        service.delete(courseId);
    }

    @RequestMapping(path = "/api/courses/update/{courseId}", method = RequestMethod.PUT)
    public void update(@PathVariable("courseId") int id, @RequestBody CourseDTO dto) {
        Course entity = converter.toEntity(dto);
        entity.setCourseId(id);
       service.update(entity);
    }

    @GetMapping("/api/courses/{id}")
    public ResponseEntity<Course> get(@PathVariable Integer id){
        try{
            Course course = service.get(id);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/coursesActive")
    public List<Course> coursesActive(){
        return service.coursesActive();
    }
}
