package com.solutions.proyecto;

import javax.persistence.*;

@Entity
@Table(name = "Canton")
public class Canton {
    @Id
    @Column(name = "Canton_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int canton_id;
    @Column(name = "Name")
    private String name;

    public Canton() {

    }

    public Canton(int canton_id, String name) {
        this.canton_id = canton_id;
        this.name = name;
    }

    public int getCanton_id() { return canton_id; }

    public void setCanton_id(int canton_id) {
        this.canton_id = canton_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
