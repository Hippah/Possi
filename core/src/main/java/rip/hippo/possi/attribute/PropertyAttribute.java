package rip.hippo.possi.attribute;

import rip.hippo.possi.Property;

/**
 * @author Hippo
 */
public interface PropertyAttribute {
  void setProperty(Property<?> property);
  Property<?> getProperty();
}
