package com.cg.hospitalmanagementsystem.entity.id;

import java.io.Serializable;
import java.util.Objects;

public class UndergoesId implements Serializable {

    private Integer patient;
    private Integer procedures;
    private Integer stay;

    public UndergoesId() {}

    public UndergoesId(Integer patient, Integer procedures, Integer stay) {
        this.patient = patient;
        this.procedures = procedures;
        this.stay = stay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UndergoesId)) return false;
        UndergoesId that = (UndergoesId) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(procedures, that.procedures) &&
                Objects.equals(stay, that.stay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, procedures, stay);
    }
}