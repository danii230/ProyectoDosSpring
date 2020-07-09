package com.solutions.dto;

public class StudentDTO {

    private int student_id;
    private int app_User;
    private String email;
    private String password;
    private String name;
    private String last_name;
    private String phone;
    private boolean admited;
    private boolean is_president;
    private String interest;
    private int province;
    private int canton;
    private int district;
    private byte[] url_photo;

    public byte[] getUrl_photo() { return url_photo; }

    public void setUrl_photo(byte[] url_photo) { this.url_photo = url_photo; }

    public int getStudent_id() { return student_id; }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getApp_User() { return app_User; }

    public void setApp_User(int app_User) { this.app_User = app_User; }

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

    public boolean admited() { return admited; }

    public void setAdmited(boolean admited) {
        this.admited = admited;
    }

    public boolean is_president() { return is_president; }

    public void setIs_president(boolean is_president) { this.is_president = is_president;}

    public int getProvince() { return province; }

    public void setProvince(int province) { this.province = province; }

    public int getCanton() { return canton; }

    public void setCanton(int canton) { this.canton = canton; }

    public int getDistrict() { return district; }

    public void setDistrict(int district) { this.district = district; }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student_id=" + student_id +
                ", app_User=" + app_User +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", admited=" + admited +
                ", province=" + province +
                ", canton=" + canton +
                ", district=" + district +
                '}';
    }


}
