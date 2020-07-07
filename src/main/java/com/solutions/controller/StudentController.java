package com.solutions.controller;


import com.solutions.converter.StudentConverter;
import com.solutions.dto.StudentDTO;
import com.solutions.proyecto.Student;
import com.solutions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin //Cors
@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentConverter converter;
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    AppUserService app_userService;
    @Autowired
    private StudentService service;

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){
        return service.findAll().stream().map(it -> converter.toDTO(it)).collect(Collectors.toList());
    }

    @GetMapping("/getStudentById/{id}")
    public StudentDTO getStudentById(@PathVariable Integer id){
        return converter.toDTO(service.findById(id));
    }

    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void insertStudent(@RequestBody StudentDTO studentDTO){
        System.out.println(studentDTO.toString());
        service.insertStudent(converter.toEntity(studentDTO));
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.PUT, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void updateStudent(@RequestBody StudentDTO studentDTO, @RequestParam("URLPhoto") MultipartFile file) throws IOException {
        studentDTO.setUrl_photo(file.getBytes());
        service.updateStudent(converter.toEntity(studentDTO));
    }

    @RequestMapping(value = "/deleteStudent/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteStudent(@PathVariable Integer id) { service.deleteStudent(id); }

}
