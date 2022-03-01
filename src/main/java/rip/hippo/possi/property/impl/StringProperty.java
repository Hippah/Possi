package rip.hippo.possi.property.impl;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.Value;
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
public final class StringProperty extends Property<String> {

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
  private final StringValue value;
  /**
   * The <tt>properties</tt> default value.
   */
  private final StringValue defaultValue;

  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public StringProperty(Group group, String name, String description, Property<?> parent, Map<String, Property<?>> children, StringValue value, StringValue defaultValue) {
    super(group, name, description, parent, children);
    this.value = value;
    this.defaultValue = defaultValue;
  }

  /**
   * @inheritDoc
   */
  @Override
  public StringValue getValue() {
    return value;
  }

  @Override
  public StringValue getDefaultValue() {
    return defaultValue;
  }
}
