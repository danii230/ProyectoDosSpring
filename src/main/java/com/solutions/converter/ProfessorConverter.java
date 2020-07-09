package com.solutions.converter;
import com.solutions.dto.ProfessorDTO;
import com.solutions.proyecto.*;
import com.solutions.service.AppUserService;
import com.solutions.service.CantonService;
import com.solutions.service.DistrictService;
import com.solutions.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@org.springframework.stereotype.Service
public class ProfessorConverter implements ConverterInterface<Professor, ProfessorDTO> {
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    AppUserService app_userService;

    @Override
    public Professor toEntity(ProfessorDTO professorDTO) {

        Province province = new Province();
        province.setProvince_id(professorDTO.getProvince());

        Canton canton = new Canton();
        canton.setCanton_id(professorDTO.getCanton());

        District district = new District();
        district.setDistrict_id(professorDTO.getDistrict());

        AppUser app_user = new AppUser();
        app_user.setApp_user_id(professorDTO.getApp_User());
        app_user.setEmail(professorDTO.getEmail());
        app_user.setPassword(professorDTO.getPassword());
        app_user.setName(professorDTO.getName());
        app_user.setLast_name(professorDTO.getLast_name());
        app_user.setPhone(professorDTO.getPhone());
        app_user.setProvince(province);
        app_user.setCanton(canton);
        app_user.setDistrict(district);
        app_user.setUrl_photo(professorDTO.getUrl_photo());

        Professor professor = new Professor();
        professor.setProfessor_id(professorDTO.getProfessor_id());
        professor.setIs_admin(professorDTO.isAdmin());
        professor.setApp_user(app_user);

        return professor;
    }

    @Override
    public ProfessorDTO toDTO(Professor professor) {
        AppUser app_User = app_userService.findbyId(professor.getApp_user().getApp_user_id());
        Province province = provinceService.findbyId(professor.getApp_user().getProvince().getProvince_id());
        Canton canton = cantonService.findbyId(professor.getApp_user().getCanton().getCanton_id());
        District district = districtService.findbyId(professor.getApp_user().getDistrict().getDistrict_id());

        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setProfessor_id(professor.getProfessor_id());
        professorDTO.setApp_User(app_User.getApp_user_id());
        professorDTO.setEmail(app_User.getEmail());
        professorDTO.setPassword(app_User.getPassword());
        professorDTO.setName(app_User.getName());
        professorDTO.setLast_name(app_User.getLast_name());
        professorDTO.setPhone(app_User.getPhone());
        professorDTO.setProvince(app_User.getProvince().getProvince_id());
        professorDTO.setCanton(app_User.getCanton().getCanton_id());
        professorDTO.setDistrict(app_User.getDistrict().getDistrict_id());
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
