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
public final class NumberProperty extends Property<Number> {

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
   * The <tt>properties</tt> default value.
   */
  public final NumberValue defaultValue;

  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public NumberProperty(Group group, String name, String description, Property<?> parent, Map<String, Property<?>> children, NumberValue value, NumberValue defaultValue) {
    super(group, name, description, parent, children);
    this.value = value;
    this.defaultValue = defaultValue;
  }

  /**
   * @inheritDoc
   */
  @Override
  public NumberValue getValue() {
    return value;
  }

  @Override
  public NumberValue getDefaultValue() {
    return defaultValue;
  }
}
