package com.littlebig.services.sourcing.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class Rfp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String name;
    protected String description;
    @Column
    @Enumerated(EnumType.STRING)
    protected RfpType rfpType;
    @Column
    protected Double maximumPrice;
    @Column
    @Enumerated(EnumType.STRING)
    protected WorkUnitType workUnitType;
    @Column
    @Enumerated(EnumType.STRING)
    RfpStatus rfpStatus;

    protected Rfp() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RfpType getRfpType() {
        return rfpType;
    }

    public void setRfpType(RfpType rfpType) {
        this.rfpType = rfpType;
    }

    public Double getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Double maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public WorkUnitType getWorkUnitType() {
        return workUnitType;
    }

    public void setWorkUnitType(WorkUnitType workUnitType) {
        this.workUnitType = workUnitType;
    }

    public RfpStatus getRfpStatus() {
        return rfpStatus;
    }

    public void setRfpStatus(RfpStatus rfpStatus) {
        this.rfpStatus = rfpStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rfp rfp = (Rfp) o;
        return Objects.equals(id, rfp.id) && Objects.equals(name, rfp.name) && Objects.equals(description, rfp.description)
            && rfpType == rfp.rfpType && Objects.equals(maximumPrice, rfp.maximumPrice) && workUnitType == rfp.workUnitType
            && rfpStatus == rfp.rfpStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, rfpType, maximumPrice, workUnitType, rfpStatus);
    }

    @Override
    public String toString() {
        return "Rfp{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", rfpType=" + rfpType +
            ", maximumPrice=" + maximumPrice +
            ", workUnitType=" + workUnitType +
            ", rfpStatus=" + rfpStatus +
            '}';
    }
}