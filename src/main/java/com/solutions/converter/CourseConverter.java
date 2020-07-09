package com.solutions.converter;

import com.solutions.proyecto.Course;
import com.solutions.dto.CourseDTO;

@org.springframework.stereotype.Service
public class CourseConverter implements  ConverterInterface<Course, CourseDTO> {

    @Override
    public Course toEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setName(dto.getName());
        entity.setInitials(dto.getInitials());
        entity.setActive(dto.isActive());
        entity.setModality(dto.getModality());
        entity.setDescription(dto.getDescription());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        return entity;
    }

    @Override
    public CourseDTO toDTO(Course entity) {
        CourseDTO dto = new CourseDTO();
//        dto.setCourseId(entity.getCourseId());
        dto.setName(entity.getName());
        dto.setInitials(entity.getInitials());
        dto.setActive(entity.isActive());
        dto.setModality(entity.getModality());
        dto.setDescription(entity.getDescription());
//        dto.setCreatedAt(entity.getCreatedAt().toString());
//        dto.setUpdatedAt(entity.getUpdatedAt().toString());
//        dto.setCreatedBy(entity.getCreatedBy());
//        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }
}
