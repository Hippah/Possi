package rip.hippo.possi.attribute.impl;

import rip.hippo.possi.attribute.AbstractPropertyAttribute;

/**
 * @author Hippo
 */
public final class DescriptionAttribute extends AbstractPropertyAttribute {

  private final String description;

  public DescriptionAttribute(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
