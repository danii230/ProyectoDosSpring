package com.solutions.proyecto;
import javax.persistence.*;

@Entity
@Table(name = "Province")
public class Province {
    @Id
    @Column(name = "Province_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int province_id;
    @Column(name = "Name")
    private String name;

    public Province() {

    }

    public Province(int province_id, String name) {
        this.province_id = province_id;
        this.name = name;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
