package com.solutions.controller;
import com.solutions.converter.ProfessorConverter;
import com.solutions.dto.ProfessorDTO;
import com.solutions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    AppUserService app_userService;
    @Autowired
    private ProfessorService service;

    @GetMapping("/getAllProfessors")
    public List<ProfessorDTO> getAllProfessors(){
        return service.findAll().stream().map(it -> converter.toDTO(it)).collect(Collectors.toList());
    }

    @GetMapping("/getProfessorById/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Integer id){
        return converter.toDTO(service.findById(id));
    }

    @RequestMapping(value = "/insertProfessor", method = RequestMethod.POST, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void insertProfessor(@RequestBody ProfessorDTO professorDTO){
        System.out.println(professorDTO.toString());
        service.insertProfessor(converter.toEntity(professorDTO));
    }

    @RequestMapping(value = "/updateProfessor", method = RequestMethod.PUT, headers =  {"Accept=application/json", "Content-type=application/json"})
    @ResponseBody
    public void updateProfessor(@RequestBody ProfessorDTO professorDTO, @RequestParam("URLPhoto") MultipartFile file) throws IOException {
        professorDTO.setUrl_photo(file.getBytes());
        service.updateProfessor(converter.toEntity(professorDTO));
    }

    @RequestMapping(value = "/deleteProfessor/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteProfessor(@PathVariable Integer id) { service.deleteProfessor(id); }

    @RequestMapping(value = "/AssignProfessorAdmin/{id}", method = RequestMethod.PUT, headers = {"Accept=application/json", "Content-type=application/json"})
    public void  AssignProfessorAdmin(@PathVariable Integer id) { service. AssignProfessorAdmin(id); }

    @RequestMapping(value = "/DisableProfessor/{id}", method = RequestMethod.PUT, headers = {"Accept=application/json", "Content-type=application/json"})
    public void  DisableProfessor(@PathVariable Integer id) { service. DisableProfessor(id); }
}

