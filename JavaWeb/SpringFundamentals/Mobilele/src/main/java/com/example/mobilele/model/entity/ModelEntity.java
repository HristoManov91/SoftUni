package com.example.mobilele.model.entity;

import com.example.mobilele.model.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum category;
    @Column(length = 512)
    private String imageUrl;
    @Column (name = "start_year")
    private Integer startYear;
    @Column
    private Integer endYear;
    @Column
    private Instant created;
    @Column
    private Instant modified;
    @ManyToOne
    private BrandEntity brand;

    public ModelEntity() {
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public ModelEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public ModelEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
