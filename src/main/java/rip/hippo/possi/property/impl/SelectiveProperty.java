package rip.hippo.possi.property.impl;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.impl.SelectiveValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 * <p>
 * A {@link Property} based around <tt>selections</tt>
 */
public final class SelectiveProperty<T> extends Property<T> {

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
  private final SelectiveValue<T> value;

  /**
   * @param value The <tt>properties</tt> value.
   * @inheritDoc
   */
  public SelectiveProperty(Group group, String name, String description, Property<?> parent, Map<String, Property<?>> children, SelectiveValue<T> value) {
    super(group, name, description, parent, children);
    this.value = value;
  }

  /**
   * @inheritDoc
   */
  @Override
  public SelectiveValue<T> getValue() {
    return value;
  }

  @Override
  public SelectiveValue<T> getDefaultValue() {
    return value;
  }
}
