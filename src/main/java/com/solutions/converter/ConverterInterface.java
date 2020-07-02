package com.solutions.converter;

public interface ConverterInterface <Entity, DTO>{
    Entity toEntity(DTO dto);
    DTO toDTO(Entity entity);
}
