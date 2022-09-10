package rip.hippo.possi.key;

import rip.hippo.possi.Property;
import rip.hippo.possi.key.impl.StandardPropertyKeyRegistry;

import java.util.List;
import java.util.Optional;

/**
 * @author Hippo
 */
public interface PropertyKeyRegistry {

  void register(PropertyKey<?> propertyKey, Property<?> property);

  List<Property<?>> getProperties(PropertyKey<?>... keys);
  Optional<Property<?>> getFirst(PropertyKey<?>... keys);

  static PropertyKeyRegistry create() {
    return new StandardPropertyKeyRegistry();
  }
}
