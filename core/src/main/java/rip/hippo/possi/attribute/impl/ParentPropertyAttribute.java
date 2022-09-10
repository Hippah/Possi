package rip.hippo.possi.attribute.impl;

import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.AbstractPropertyAttribute;

/**
 * @author Hippo
 */
public final class ParentPropertyAttribute extends AbstractPropertyAttribute {

  private final Property<?> parent;

  public ParentPropertyAttribute(Property<?> parent) {
    this.parent = parent;
  }

  public Property<?> getParent() {
    return parent;
  }
}
