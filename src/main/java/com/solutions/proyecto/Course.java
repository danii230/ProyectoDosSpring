package com.solutions.proyecto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String initials;
    private String name;
    private boolean active;
    private String modality;
    private String Description;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;
    private String CreatedBy;
    private String UpdatedBy;

    public Course(int courseId, String initials, String name, boolean active, String modality, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.courseId = courseId;
        this.initials = initials;
        this.name = name;
        this.active = active;
        this.modality = modality;
        Description = description;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
    }

    public Course(){}

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", initials='" + initials + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", modality='" + modality + '\'' +
                ", Description='" + Description + '\'' +
                ", CreatedAt=" + CreatedAt +
                ", UpdatedAt=" + UpdatedAt +
                ", CreatedBy='" + CreatedBy + '\'' +
                ", UpdatedBy='" + UpdatedBy + '\'' +
                '}';
    }
}
