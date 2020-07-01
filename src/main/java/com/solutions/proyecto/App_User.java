package com.solutions.proyecto;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AppUser")
public class App_User {
    @Id
    @Column(name = "App_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int app_user_id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "URL_photo")
    private byte[] url_photo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Last_name")
    private String last_name;
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
    @Column(name = "Create_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date create_at;
    @Column(name = "Update_at")
    @Temporal(TemporalType.DATE) //maneja de datetime a date
    private Date update_at;
    @Column(name = "Create_by")
    private String create_by;
    @Column(name = "Update_by")
    private String update_by;

    public App_User() {

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

    public byte[] getUrl_photo() {
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
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
