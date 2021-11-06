package com.example.demojsp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Entity2 implements Serializable {
    @Id
    private Long id;
    private String value;

    @MapsId
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private Entity1 entity1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Entity1 getEntity1() {
        return entity1;
    }

    public void setEntity1(Entity1 entity1) {
        this.entity1 = entity1;
    }
}
