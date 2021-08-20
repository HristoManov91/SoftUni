package com.example.mobilelele.model.entity;

import net.bytebuddy.asm.Advice;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Instant created;
    @Column
    private Instant modified;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
