package com.solutions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class CourseDTO {

    private String initials;
    private String name;
    private boolean active;
    private String modality;
    private String description;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime updatedAt = LocalDateTime.now();


    @JsonIgnore
    private final String createdBy = "Test";


    @JsonIgnore
    private final String updatedBy = "Test";


    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }


    @Override
    public String toString() {
        return "CourseDTO{" +
                ", initials='" + initials + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", modality='" + modality + '\'' +
                ", Description='" + description + '\'' +
                ", CreatedAt='" + createdAt + '\'' +
                ", UpdatedAt='" + updatedAt + '\'' +
                ", CreatedBy='" + createdBy + '\'' +
                ", UpdatedBy='" + updatedBy + '\'' +
                '}';
    }
}
