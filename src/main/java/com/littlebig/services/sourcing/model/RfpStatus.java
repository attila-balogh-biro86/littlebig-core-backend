package com.littlebig.services.sourcing.model;

public enum RfpStatus {
  CREATED(0),
  PUBLISHED(1),
  STARTED(2),
  MISSION_PENDING(3),
  CLOSED(4),
  DELETED(5),
  CANDIDATE(6),
  BUYER_PENDING(7),
  DRAFT(8),
  TRANSFORMATION_PENDING(9),
  REFUSED(10),
  FULL_TEAM(11),
  EXTENSION_REFUSED_BY_PRESTA(12),
  WAITING_EXTENSION(13),
  PENDING_PURCHASE_REQUEST(14),
  AWAITING_PR_CREATION(15);


  private final int value;

  private RfpStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   *
   * @return null if the value is not found.
   */
  public static RfpStatus findByValue(int value) {
    switch (value) {
      case 0:
        return CREATED;
      case 1:
        return PUBLISHED;
      case 2:
        return STARTED;
      case 3:
        return MISSION_PENDING;
      case 4:
        return CLOSED;
      case 5:
        return DELETED;
      case 6:
        return CANDIDATE;
      case 7:
        return BUYER_PENDING;
      case 8:
        return DRAFT;
      case 9:
        return TRANSFORMATION_PENDING;
      case 10:
        return REFUSED;
      case 11:
        return FULL_TEAM;
      case 12:
        return EXTENSION_REFUSED_BY_PRESTA;
      case 13:
        return WAITING_EXTENSION;
      case 14:
        return AWAITING_PR_CREATION;
      default:
        return null;
    }
  }
}

