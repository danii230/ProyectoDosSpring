package com.solutions.proyecto;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Professor")
public class Professor {
    @Id
    @Column(name = "Professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professor_id;
    @Column(name = "Is_Admin")
    @Type(type = "numeric_boolean")  //maneja cuando el boolean es numeral
    private boolean is_admin;
    @OneToOne
    @JoinColumn(name = "App_User")
    private AppUser app_user;
    @Column(name = "Created_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date create_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date update_at;
    @Column(name = "Created_by")
    private String create_by;
    @Column(name = "Updated_by")
    private String update_by;

    public Professor(){

    }

    public Professor(int professor_id, boolean is_admin, AppUser app_user, Date create_at, Date update_at, String create_by, String update_by){
        this.professor_id = professor_id;
        this.is_admin = is_admin;
        this.app_user = app_user;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public AppUser getApp_user() {
        return app_user;
    }

    public void setApp_user(AppUser app_user) {
        this.app_user = app_user;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
