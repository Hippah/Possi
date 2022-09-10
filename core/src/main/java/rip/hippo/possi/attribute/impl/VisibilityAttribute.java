package rip.hippo.possi.attribute.impl;

import rip.hippo.possi.attribute.AbstractPropertyAttribute;

/**
 * @author Hippo
 */
public final class VisibilityAttribute extends AbstractPropertyAttribute {
  public static final int STOP_LOOKUP = 1;
  public static final int STOP_SOURCE = 2;

  public static final VisibilityAttribute STOP_NONE = new VisibilityAttribute(0);

  private int flags;

  public VisibilityAttribute(int flags) {
    this.flags = flags;
  }

  public int getFlags() {
    return flags;
  }

  public void setFlags(int flags) {
    if (this == STOP_NONE) {
      return;
    }
    this.flags = flags;
  }

  public boolean isStopLookup() {
    return (flags & STOP_LOOKUP) != 0;
  }

  public boolean isStopSource() {
    return (flags & STOP_SOURCE) != 0;
  }
}
