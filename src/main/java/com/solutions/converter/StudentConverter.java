package com.solutions.converter;
import com.solutions.dto.StudentDTO;
import com.solutions.proyecto.*;
import com.solutions.service.AppUserService;
import com.solutions.service.CantonService;
import com.solutions.service.DistrictService;
import com.solutions.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class StudentConverter implements ConverterInterface<Student, StudentDTO> {

    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    AppUserService app_userService;

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        Province province = new Province();
        province.setProvince_id(studentDTO.getProvince());

        Canton canton = new Canton();
        canton.setCanton_id(studentDTO.getCanton());


        District district = new District();
        district.setDistrict_id(studentDTO.getDistrict());


        AppUser app_user = new AppUser();
        app_user.setApp_user_id(studentDTO.getApp_User());
        app_user.setEmail(studentDTO.getEmail());
        app_user.setPassword(studentDTO.getPassword());
        app_user.setName(studentDTO.getName());
        app_user.setLast_name(studentDTO.getLast_name());
        app_user.setPhone(studentDTO.getPhone());
        app_user.setProvince(province);
        app_user.setCanton(canton);
        app_user.setDistrict(district);
        app_user.setUrl_photo(studentDTO.getUrl_photo());

        Student student = new Student();
        student.setStudent_id(studentDTO.getStudent_id());
        student.setIs_President(studentDTO.is_president());
        student.setAdmited(studentDTO.admited());
        student.setApp_user(app_user);

        return student;
    }

    @Override
    public StudentDTO toDTO(Student student) {

        AppUser app_User = app_userService.findbyId(student.getApp_user().getApp_user_id());
        Province province = provinceService.findbyId(student.getApp_user().getProvince().getProvince_id());
        Canton canton = cantonService.findbyId(student.getApp_user().getCanton().getCanton_id());
        District district = districtService.findbyId(student.getApp_user().getDistrict().getDistrict_id());

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudent_id(student.getStudent_id());
        studentDTO.setApp_User(app_User.getApp_user_id());
        studentDTO.setEmail(app_User.getEmail());
        studentDTO.setPassword(app_User.getPassword());
        studentDTO.setName(app_User.getName());
        studentDTO.setLast_name(app_User.getLast_name());
        studentDTO.setPhone(app_User.getPhone());
        studentDTO.setProvince(app_User.getProvince().getProvince_id());
        studentDTO.setCanton(app_User.getCanton().getCanton_id());
        studentDTO.setDistrict(app_User.getDistrict().getDistrict_id());
        studentDTO.setAdmited(student.isAdmited());
        studentDTO.setIs_president(student.isIs_President());

        return studentDTO;
    }
}
