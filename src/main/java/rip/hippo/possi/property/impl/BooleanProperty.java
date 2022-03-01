package rip.hippo.possi.property.impl;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.impl.BooleanValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 * <p>
 * A {@link Property} based around {@link Boolean}s.
 */
public final class BooleanProperty extends Property<Boolean> {

  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 3L;

  /**
   * The <tt>properties</tt> value.
   */
  private final BooleanValue value;
  /**
   * The <tt>properties</tt> default value.
   */
  private final BooleanValue defaultValue;


  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public BooleanProperty(Group group, String name, String description, Property<?> parent, Map<String, Property<?>> children, BooleanValue value, BooleanValue defaultValue) {
    super(group, name, description, parent, children);
    this.value = value;
    this.defaultValue = defaultValue;
  }

  /**
   * @inheritDoc
   */
  @Override
  public BooleanValue getValue() {
    return value;
  }

  @Override
  public BooleanValue getDefaultValue() {
    return defaultValue;
  }
}
