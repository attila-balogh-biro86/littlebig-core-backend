package com.littlebig.services.sourcing.model;

public enum WorkUnitType {
  HOURS(0, "Hours"),
  DAYS(1, "Days"),
  MONTHS(2, "Months"),
  PACKAGE(3, "Package");

  private final int value;
  private final String description;


  WorkUnitType(int value, String description) {
    this.value = value;
    this.description = description;
  }

  public int getValue() {
    return value;
  }


  public static WorkUnitType findByValue(int value) {
    return switch (value) {
      case 0 -> HOURS;
      case 1 -> DAYS;
      case 2 -> MONTHS;
      case 3 -> PACKAGE;
      default -> null;
    };
  }

  public String getDescription() {
    return this.description;
  }
}
