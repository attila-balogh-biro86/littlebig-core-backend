package com.littlebig.services.sourcing.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class RiseRfp extends Rfp {

  @Column
  private UUID preferredSupplierClientId;

  public RiseRfp(){
    super();
    setRfpType(RfpType.RISE);
    setRfpStatus(RfpStatus.PUBLISHED);
  }

  public UUID getPreferredSupplierClientId() {
    return preferredSupplierClientId;
  }

  public void setPreferredSupplierClientId(UUID rfpApplicantId) {
    this.preferredSupplierClientId = rfpApplicantId;
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
    RiseRfp riseRfp = (RiseRfp) o;
    return Objects.equals(preferredSupplierClientId, riseRfp.preferredSupplierClientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), preferredSupplierClientId);
  }

  @Override
  public String toString() {
    return "RiseRfp{" +
        "rfpApplicantId=" + preferredSupplierClientId +
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
