package rip.hippo.possi.property;

import rip.hippo.possi.group.Group;
import rip.hippo.possi.value.Value;
import rip.hippo.possi.value.callback.PropertyValueCallback;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 * <p>
 * An object representing a property, which is registered under a {@link Group}, and must have a {@link Value}.
 * </p>
 * @param <T> The type for the {@link Value}.
 */
public abstract class Property<T> implements Serializable {
  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 3L;

  /**
   * The group the <tt>property</tt> is registered under.
   */
  private final Group group;
  /**
   * The name of the <tt>property</tt>.
   */
  private final String name;
  /**
   * The description of the <tt>property</tt>. May be {@code null}.
   */
  private final String description;
  /**
   * The <tt>properties</tt> children, mapped to their <tt>name</tt>.
   */
  private final Map<String, Property<?>> children;
  /**
   * The parent <tt>property</tt>. May be {@code null}.
   */
  private Property<?> parent;

  /**
   * Constructs a <tt>property</tt> with the desired group, name, parent, and children.
   *
   * @param group    The group.
   * @param name     The name.
   * @param parent   The parent, may be {@code null}.
   * @param children The children.
   */
  public Property(Group group, String name, String description, Property<?> parent, Map<String, Property<?>> children) {
    this.group = group;
    this.name = name;
    this.description = description;
    this.parent = parent;
    this.children = Collections.unmodifiableMap(children);
  }

  /**
   * Gets an {@code instance} of the <tt>properties</tt> {@link Value}.
   *
   * @return The value.
   */
  public abstract Value<T> getValue();

  /**
   * Gets an {@code instance} of the <tt>properties</tt> default {@link Value}.
   *
   * @return The default value.
   */
  public abstract Value<T> getDefaultValue();

  public PropertyValueCallback<?> reset() {
    return getValue().update(getDefaultValue().get());
  }

  /**
   * Gets the <tt>properties</tt> group.
   *
   * @return The group.
   */
  public Group getGroup() {
    return group;
  }

  /**
   * Gets the <tt>properties</tt> name.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the <tt>properties</tt> description.
   *
   * @return The description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the <tt>properties</tt> parent.
   *
   * @return The parent.
   */
  public Property<?> getParent() {
    return parent;
  }

  /**
   * Sets the <tt>properties</tt> parent.
   *
   * @param parent The parent.
   */
  public void setParent(Property<?> parent) {
    this.parent = parent;
  }

  /**
   * Gets the <tt>properties</tt> children.
   *
   * @return The children.
   */
  public Map<String, Property<?>> getChildren() {
    return children;
  }
}
