package com.example.demojsp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Entity1 implements Serializable {
    @Id
    private Long id;
    private String name;

    @OneToOne(mappedBy = "entity1", cascade = CascadeType.ALL)
    private Entity2 entity2;

    @OneToOne(mappedBy = "entity1", cascade = CascadeType.ALL)
    private Entity3 entity3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity2 getEntity2() {
        return entity2;
    }

    public void setEntity2(Entity2 entity2) {
        this.entity2 = entity2;
    }

    public Entity3 getEntity3() {
        return entity3;
    }

    public void setEntity3(Entity3 entity3) {
        this.entity3 = entity3;
    }
}
