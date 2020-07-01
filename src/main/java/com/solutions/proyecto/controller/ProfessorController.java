package com.solutions.proyecto.controller;

import com.solutions.proyecto.App_User;
import com.solutions.proyecto.Professor;
import com.solutions.proyecto.ProfessorDTO;
import com.solutions.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin //Cors
@RestController
@RequestMapping(path = "/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessorConverter converter;
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    App_UserService app_userService;
    @Autowired
    private ProfessorService service;

    @GetMapping("/getAllProfessors")
    public List<ProfessorDTO> getAllProfessors(){
        return service.findAll().stream().map(it -> converter.toDTO(it)).collect(Collectors.toList());
    }

    @GetMapping("/getProfessorById/{id}")
    public ProfessorDTO getStudentById(@PathVariable Integer id){
        return converter.toDTO(service.findById(id));
    }

    @RequestMapping(value = "/insertProfessor", method = RequestMethod.POST, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void insertProfessor(@RequestBody ProfessorDTO professorDTO){
        service.insertProfessor(converter.toEntity(professorDTO));
    }

    @RequestMapping(value = "/updateProfessor", method = RequestMethod.PUT, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void updateProfessor(@RequestBody ProfessorDTO professorDTO){
        service.updateProfessor(converter.toEntity(professorDTO));
    }

    @RequestMapping(value = "/deleteProfessor/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteProfessor(@PathVariable Integer id) { service.deleteProfessor(id); }

}
