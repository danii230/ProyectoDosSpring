package com.solutions.proyecto;

public class ProfessorDTO {

    private int professor_id;
    private int app_User;
    private String email;
    private String password;
    private String name;
    private String last_name;
    private String phone;
    private boolean isAdmin;

    public int getProfessor_id() { return professor_id; }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
