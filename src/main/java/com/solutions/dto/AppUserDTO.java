package com.solutions.dto;

public class AppUserDTO {

    private int app_User_id;

    public int getApp_User_id() {
        return app_User_id;
    }

    public void setApp_User_id(int app_User_id) {
        this.app_User_id = app_User_id;
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

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public byte[] getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(byte[] url_photo) {
        this.url_photo = url_photo;
    }

    private String email;
    private String password;
    private String name;
    private String last_name;
    private String phone;
    private int province;
    private int canton;
    private int district;
    private byte[] url_photo;
}
