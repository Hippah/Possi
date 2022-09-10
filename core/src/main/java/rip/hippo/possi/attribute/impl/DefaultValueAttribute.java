package rip.hippo.possi.attribute.impl;


import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.AbstractPropertyAttribute;

/**
 * @author Hippo
 */
public final class DefaultValueAttribute<T> extends AbstractPropertyAttribute {

  private final T value;

  public DefaultValueAttribute(T value) {
    this.value = value;
  }

  @SuppressWarnings("unchecked")
  public void setDefaultValue() {
    Property<T> property = (Property<T>) getProperty();
    property.set(value);
  }

  public T getValue() {
    return value;
  }
}
