package com.solutions.converter;

import com.solutions.dto.AppUserDTO;
import com.solutions.dto.ProfessorDTO;
import com.solutions.dto.StudentDTO;
import com.solutions.proyecto.*;
import com.solutions.service.AppUserService;
import com.solutions.service.CantonService;
import com.solutions.service.DistrictService;
import com.solutions.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UserConverter implements ConverterInterface<AppUser, AppUserDTO>{
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    AppUserService app_userService;

    @Override
    public AppUser toEntity(AppUserDTO appUserDTO) {
        Province province = new Province();
        province.setProvince_id(appUserDTO.getProvince());

        Canton canton = new Canton();
        canton.setCanton_id(appUserDTO.getCanton());

        District district = new District();
        district.setDistrict_id(appUserDTO.getDistrict());

        AppUser app_user = new AppUser();
        app_user.setApp_user_id(appUserDTO.getApp_User_id());
        app_user.setEmail(appUserDTO.getEmail());
        app_user.setPassword(appUserDTO.getPassword());
        app_user.setName(appUserDTO.getName());
        app_user.setLast_name(appUserDTO.getLast_name());
        app_user.setPhone(appUserDTO.getPhone());
        app_user.setProvince(province);
        app_user.setCanton(canton);
        app_user.setDistrict(district);
        app_user.setUrl_photo(appUserDTO.getUrl_photo());

        return app_user;
    }

    @Override
    public AppUserDTO toDTO(AppUser appUser) {
        Province province = provinceService.findbyId(appUser.getProvince().getProvince_id());
        Canton canton = cantonService.findbyId(appUser.getCanton().getCanton_id());
        District district = districtService.findbyId(appUser.getDistrict().getDistrict_id());

//        AppUserDTO userDTO = new AppUserDTO();
//        userDTO.setApp_User_id(app_User.getApp_user_id());
//        userDTO.setEmail(app_User.getEmail());
//        userDTO.setPassword(app_User.getPassword());
//        userDTO.setName(app_User.getName());
//        userDTO.setLast_name(app_User.getLast_name());
//        userDTO.setPhone(app_User.getPhone());
//        userDTO.setProvince(app_User.getProvince().getProvince_id());
//        userDTO.setCanton(app_User.getCanton().getCanton_id());
//        userDTO.setDistrict(app_User.getDistrict().getDistrict_id());

        return null;

    }
}
