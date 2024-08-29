package com.littlebig.services.common.exception;

import java.util.Objects;
import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

  private final UUID id;

  public ResourceNotFoundException(String message, UUID id) {
        super(message);
        this.id = id;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceNotFoundException that = (ResourceNotFoundException) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "The resource with id not found {" +
        "id=" + id +
        '}';
  }
}
