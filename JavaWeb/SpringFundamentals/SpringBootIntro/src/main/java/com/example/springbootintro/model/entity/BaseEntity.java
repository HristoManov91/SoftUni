package com.example.springbootintro.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public BaseEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public BaseEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
