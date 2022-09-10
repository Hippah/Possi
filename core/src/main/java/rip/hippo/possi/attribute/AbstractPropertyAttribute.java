package rip.hippo.possi.attribute;

import rip.hippo.possi.Property;

import java.util.Objects;

/**
 * @author Hippo
 */
public abstract class AbstractPropertyAttribute implements PropertyAttribute {

  private Property<?> property;

  @Override
  public void setProperty(Property<?> property) {
    this.property = property;
  }

  @Override
  public Property<?> getProperty() {
    return Objects.requireNonNull(property, "Property is null");
  }
}
