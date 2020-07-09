package com.solutions.proyecto;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "App_User")
public class AppUser {

    @Id
    @Column(name = "App_User_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int app_user_id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "URL_Photo")
    private byte[] url_photo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Phone")
    private String phone;
    @ManyToOne()
    @JoinColumn(name = "Province")
    private Province province;
    @ManyToOne()
    @JoinColumn(name = "Canton")
    private Canton canton;
    @ManyToOne()
    @JoinColumn(name = "District")
    private District district;
    @Column(name = "Interest", columnDefinition = "TEXT") //columna tipo texto
    private String interest;
    @Column(name = "Status")
    @Type(type = "numeric_boolean") //maneja cuando el boolean es numeral
    private boolean status;
    @Column(name = "Created_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date created_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date updated_at;
    @Column(name = "Created_by")
    private String created_by;
    @Column(name = "Updated_by")
    private String updated_by;

    public AppUser() {

    }

    public int getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(int app_user_id) {
        this.app_user_id = app_user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getUrl_Photo() {
        return url_photo;
    }

    public void setUrl_photo(byte[] url_photo) {
        this.url_photo = url_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return lastname;
    }

    public void setLast_name(String last_name) {
        this.lastname = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date create_at) {
        this.created_at = create_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date update_at) {
        this.updated_at = update_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String create_by) {
        this.created_by = create_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String update_by) {
        this.updated_by = update_by;
    }
}
