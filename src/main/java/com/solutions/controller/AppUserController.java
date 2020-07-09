package com.solutions.controller;

import com.solutions.converter.ProfessorConverter;
import com.solutions.converter.StudentConverter;
import com.solutions.converter.UserConverter;
import com.solutions.dto.AppUserDTO;
import com.solutions.dto.LoginDTO;
import com.solutions.dto.ProfessorDTO;
import com.solutions.dto.StudentDTO;
import com.solutions.proyecto.AppUser;
import com.solutions.proyecto.Professor;
import com.solutions.proyecto.Student;
import com.solutions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@CrossOrigin //Cors
@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    AppUserService app_userService;
    @Autowired
    private ProfessorConverter profressorConverter;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private AppUserService service;

    @RequestMapping(value = "/professorlogin", method = RequestMethod.POST, headers = {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public ProfessorDTO professorLogin(@RequestBody LoginDTO loginDTO) throws IOException {
        try {
            return profressorConverter.toDTO(service.authProfessor(loginDTO.getEmail(), loginDTO.getPassword()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/studentlogin", method = RequestMethod.POST, headers = {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public StudentDTO studentLogin(@RequestBody LoginDTO loginDTO) throws IOException {
        try {
            return studentConverter.toDTO(service.authStudent(loginDTO.getEmail(), loginDTO.getPassword()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
