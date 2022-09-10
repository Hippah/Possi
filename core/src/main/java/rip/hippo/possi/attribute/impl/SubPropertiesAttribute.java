package rip.hippo.possi.attribute.impl;

import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.AbstractPropertyAttribute;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hippo
 */
public final class SubPropertiesAttribute extends AbstractPropertyAttribute {

  private final List<Property<?>> properties;

  public SubPropertiesAttribute(Property<?>... properties) {
    this.properties = Arrays.asList(properties);
  }

  public SubPropertiesAttribute(List<Property<?>> properties) {
    this.properties = properties;
  }

  public List<Property<?>> getProperties() {
    return properties;
  }
}
