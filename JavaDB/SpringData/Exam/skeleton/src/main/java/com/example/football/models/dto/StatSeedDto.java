package com.example.football.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedDto {

    @XmlElement (name = "passing")
    private Float passing;
    @XmlElement (name = "shooting")
    private Float shooting;
    @XmlElement (name = "endurance")
    private Float endurance;

    @Min(1)
    public Float getPassing() {
        return passing;
    }

    public void setPassing(Float passing) {
        this.passing = passing;
    }

    @Min(1)
    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    @Min(1)
    public Float getEndurance() {
        return endurance;
    }

    public void setEndurance(Float endurance) {
        this.endurance = endurance;
    }
}
