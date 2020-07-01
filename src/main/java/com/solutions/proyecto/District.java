package com.solutions.proyecto;
import javax.persistence.*;

@Entity
@Table(name = "District")
public class District {
    @Id
    @Column(name = "District_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int district_id;
    @Column(name = "Name")
    private String name;

    public District() {

    }

    public District(int district_id, String name) {
        this.district_id = district_id;
        this.name = name;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
