package com.example.mobilele.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{

    @Column
    private String name;
    @Column
    private Instant created;
    @Column
    private Instant modified;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BrandEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BrandEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}
