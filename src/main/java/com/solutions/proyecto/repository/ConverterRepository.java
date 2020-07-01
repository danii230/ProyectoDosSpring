package com.solutions.proyecto.repository;

public interface ConverterRepository <Entity, DTO> {
    Entity toEntity(DTO dto);
    DTO toDTO(Entity entity);
}
