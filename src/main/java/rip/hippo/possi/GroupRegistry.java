package rip.hippo.possi;

import rip.hippo.possi.group.Group;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 * <p>
 * Manages property {@link Group}s.
 * Is responsible for storing and creating {@link Group}s.
 */
public final class GroupRegistry implements Serializable {

  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 2L;

  /**
   * Maps a name to a {@link Group} object.
   */
  private final Map<String, Group> groups;

  /**
   * Constructs a new <tt>GroupManger</tt> with empty {@link GroupRegistry#groups}
   */
  public GroupRegistry() {
    this.groups = new HashMap<>();
  }

  /**
   * Registers a new {@link Group} with the name being <tt>name</tt> and no <tt>parent</tt>.
   *
   * @param name The name of the group.
   * @return The group registered.
   */
  public Group registerGroup(String name) {
    return registerGroup(name, null);
  }


  /**
   * Registers a new {@link Group} with the name being <tt>name</tt> under the <tt>parent</tt>.
   *
   * @param name   The name of the group.
   * @param parent The parent the group is under.
   * @return The registered group.
   */
  public Group registerGroup(String name, Group parent) {
    Group group = new Group(name, parent);
    groups.put(name, group);
    return group;
  }

  /**
   * Gets a {@link Group} object by <tt>name</tt>.
   *
   * @param group The name of the group.
   * @return The group.
   */
  public Group getGroup(String group) {
    return groups.get(group);
  }
}
