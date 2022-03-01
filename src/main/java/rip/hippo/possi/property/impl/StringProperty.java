package rip.hippo.possi.property.impl;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.impl.StringValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 * <p>
 * A {@link Property} based around {@link String}s.
 */
public final class StringProperty extends Property {

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
  private final StringValue value;

  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public StringProperty(Group group, String name, Property parent, Map<String, Property> children, StringValue value) {
    super(group, name, parent, children);
    this.value = value;
  }

  /**
   * @inheritDoc
   */
  @Override
  public StringValue getValue() {
    return value;
  }
}
