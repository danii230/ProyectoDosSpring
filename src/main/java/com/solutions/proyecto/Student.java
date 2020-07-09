package com.solutions.proyecto;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(name = "Is_President")
    @Type(type = "numeric_boolean")  //maneja cuando el boolean es numeral
    private boolean is_President;
    @Column(name = "Admited")
    @Type(type = "numeric_boolean")  //maneja cuando el boolean es numeral
    private boolean Admited;
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

   public Student(){

   }

    public Student(int student_id, boolean is_President, boolean admited, AppUser app_user, Date create_at, Date update_at, String create_by, String update_by) {
        this.student_id = student_id;
        this.is_President = is_President;
        this.Admited = admited;
        this.app_user = app_user;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public int getStudent_id() { return student_id; }

    public void setStudent_id(int professor_id) { this.student_id = professor_id; }

    public boolean isIs_President() { return is_President; }

    public void setIs_President(boolean is_President) { this.is_President = is_President; }

    public boolean isAdmited() { return Admited; }

    public void setAdmited(boolean admited) { Admited = admited; }

    public AppUser getApp_user() { return app_user; }

    public void setApp_user(AppUser app_user) { this.app_user = app_user; }

    public Date getCreate_at() { return create_at; }

    public void setCreate_at(Date create_at) { this.create_at = create_at; }

    public Date getUpdate_at() { return update_at; }

    public void setUpdate_at(Date update_at) { this.update_at = update_at; }

    public String getCreate_by() { return create_by; }

    public void setCreate_by(String create_by) { this.create_by = create_by; }

    public String getUpdate_by() { return update_by; }

    public void setUpdate_by(String update_by) { this.update_by = update_by; }
}
