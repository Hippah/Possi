package rip.hippo.possi.property.impl;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.impl.NumberValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 * <p>
 * A {@link Property} based around {@link Number}s.
 */
public final class NumberProperty extends Property {

  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 2L;

  /**
   * The <tt>properties</tt> value.
   */
  public final NumberValue value;

  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public NumberProperty(Group group, String name, Property parent, Map<String, Property> children, NumberValue value) {
    super(group, name, parent, children);
    this.value = value;
  }

  /**
   * @inheritDoc
   */
  @Override
  public NumberValue getValue() {
    return value;
  }
}
