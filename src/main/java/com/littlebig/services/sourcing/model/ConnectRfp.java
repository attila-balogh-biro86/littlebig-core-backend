package com.littlebig.services.sourcing.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class ConnectRfp extends Rfp{

  @Column
  private UUID rfpApplicantClientId;

  @Column
  private boolean active = false;

  public ConnectRfp() {
    super();
    setRfpType(RfpType.CONNECT);
    setRfpStatus(RfpStatus.DRAFT);
  }

  public UUID getRfpApplicantClientId() {
    return rfpApplicantClientId;
  }

  public void setRfpApplicantClientId(UUID appliedClientID) {
    this.rfpApplicantClientId = appliedClientID;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ConnectRfp that = (ConnectRfp) o;
    return active == that.active && Objects.equals(rfpApplicantClientId, that.rfpApplicantClientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rfpApplicantClientId, active);
  }

  @Override
  public String toString() {
    return "ConnectRfp{" +
        "appliedClientID=" + rfpApplicantClientId +
        ", active=" + active +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", rfpType=" + rfpType +
        ", maximumPrice=" + maximumPrice +
        ", workUnitType=" + workUnitType +
        ", rfpStatus=" + rfpStatus +
        '}';
  }
}
