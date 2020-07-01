package com.solutions.proyecto.service;

import com.solutions.proyecto.*;
import com.solutions.proyecto.repository.ConverterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@org.springframework.stereotype.Service
public class ProfessorConverter implements ConverterRepository<Professor, ProfessorDTO> {
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    App_UserService app_userService;

    @Override
    public Professor toEntity(ProfessorDTO professorDTO) {

        App_User app_user = new App_User();
        app_user.setApp_user_id(professorDTO.getApp_User());
        app_user.setEmail(professorDTO.getEmail());
        app_user.setPassword(RandomNumericPassword()); //crea una contraseña numerica aleatoria de 8 digitos
        app_user.setName(professorDTO.getName());
        app_user.setLast_name(professorDTO.getLast_name());
        app_user.setPhone(professorDTO.getPhone());

        Professor professor = new Professor();
        professor.setProfessor_id(professorDTO.getProfessor_id());
        professor.setIs_admin(professorDTO.isAdmin());
        professor.setApp_user(app_user);

        return professor;
    }

    @Override
    public ProfessorDTO toDTO(Professor professor) {
        App_User app_User = app_userService.findbyId(professor.getApp_user().getApp_user_id());

        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setProfessor_id(professor.getProfessor_id());
        professorDTO.setApp_User(app_User.getApp_user_id());
        professorDTO.setEmail(app_User.getEmail());
        professorDTO.setPassword(app_User.getPassword());
        professorDTO.setName(app_User.getName());
        professorDTO.setLast_name(app_User.getLast_name());
        professorDTO.setPhone(app_User.getPhone());
        professorDTO.setAdmin(professor.isIs_admin());

        return professorDTO;
    }

    private String RandomNumericPassword(){
        String password = "";
        Random random = new Random();

        for(int i=1; i <= 8; i++){
            password += "" + random.nextInt(10);
        }

        return password;
    }
}
