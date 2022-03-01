package rip.hippo.possi.group;

import rip.hippo.possi.property.Property;
import rip.hippo.possi.property.builder.PropertyBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 * <p>
 * An object that holds {@link Property}s and their children.
 */
public final class Group {

  /**
   * The name of the group.
   */
  private final String name;

  /**
   * The group that {@code this} is registered under. May be {@code null}.
   */
  private final Group parent;

  /**
   * All the {@link Property}s mapped to their name.
   */
  private final Map<String, Property<?>> properties;

  /**
   * All the child {@link Group}s mapped to their name.
   */
  private final Map<String, Group> children;

  /**
   * Constructs a <tt>Group</tt> with the desired name and parent.
   *
   * @param name   The name of the group.
   * @param parent The parent of the group, may be {@code null}.
   */
  public Group(String name, Group parent) {
    this.name = name;
    this.parent = parent;
    this.properties = new HashMap<>();
    this.children = new HashMap<>();
  }

  /**
   * Gets a new {@link PropertyBuilder} to build a {@link Property}.
   *
   * @return The property builder.
   */
  public PropertyBuilder buildProperty() {
    return new PropertyBuilder(this);
  }

  /**
   * Gets a {@link Property} by its name.
   *
   * @param name The name to look up by.
   * @return The property.
   */
  public Property getProperty(String name) {
    return properties.get(name);
  }

  /**
   * Checks if a {@link Property} with <tt>name</tt> exist.
   *
   * @param name The name to look up by.
   * @return If the property exist.
   */
  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  /**
   * Gets a child {@link Group} by its name.
   *
   * @param name The name to look up by.
   * @return The child.
   */
  public Group getChild(String name) {
    return children.get(name);
  }

  /**
   * Checks if a {@link Group} with <tt>name</tt> exist.
   *
   * @param name The name to look up by.
   * @return If the property exist.
   */
  public boolean hasChild(String name) {
    return children.containsKey(name);
  }

  /**
   * Gets the groups name.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the groups properties.
   *
   * @return The properties.
   */
  public Map<String, Property<?>> getProperties() {
    return properties;
  }

  /**
   * Gets the groups children.
   *
   * @return The children.
   */
  public Map<String, Group> getChildren() {
    return children;
  }
}
