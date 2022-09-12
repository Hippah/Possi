package rip.hippo.possi.testing;

import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.key.PropertyKeyRegistry;
import rip.hippo.possi.key.keys.NameKey;
import rip.hippo.possi.key.keys.OwnerKey;

/**
 * @author Hippo
 */
public final class PropertyKeyTest {

  @Test
  public void test() {
    PropertyKeyRegistry propertyKeyRegistry = PropertyKeyRegistry.create();

    Property.of("Default Property Value")
        .withKey(propertyKeyRegistry, new NameKey("String Name"))
        .withKey(propertyKeyRegistry, new OwnerKey(this));

    Property.of(true)
        .withKey(propertyKeyRegistry, new NameKey("Boolean Name"))
        .withKey(propertyKeyRegistry, new OwnerKey(this));

    System.out.println("Name lookups:");
    propertyKeyRegistry.getFirst(new NameKey("String Name")).ifPresent(System.out::println);
    propertyKeyRegistry.getFirst(new NameKey("Boolean Name")).ifPresent(System.out::println);
    System.out.println("\nOwner lookup:");
    propertyKeyRegistry.getProperties(new OwnerKey(this)).forEach(System.out::println);

  }
}
