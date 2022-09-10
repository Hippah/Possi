package rip.hippo.possi.key.impl;

import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.impl.VisibilityAttribute;
import rip.hippo.possi.key.PropertyKey;
import rip.hippo.possi.key.PropertyKeyRegistry;

import java.util.*;

/**
 * @author Hippo
 */
public final class StandardPropertyKeyRegistry implements PropertyKeyRegistry {

  private final Map<Class<?>, Map<Object, List<Property<?>>>> propertyKeyMap = new HashMap<>();

  @Override
  public void register(PropertyKey<?> propertyKey, Property<?> property) {
    propertyKeyMap.computeIfAbsent(propertyKey.getClass(), ignored -> new HashMap<>())
        .computeIfAbsent(propertyKey.getKeyValue(), ignored -> new LinkedList<>())
        .add(property);
  }

  @Override
  public List<Property<?>> getProperties(PropertyKey<?>... keys) {
    List<Property<?>> properties = new LinkedList<>();

    for (PropertyKey<?> key : keys) {
      Map<Object, List<Property<?>>> keyMap = propertyKeyMap.get(key.getClass());
      if (keyMap == null) {
        continue;
      }
      List<Property<?>> propertyList = keyMap.get(key.getKeyValue());
      if (propertyList == null) {
        continue;
      }

      for (Property<?> property : propertyList) {
        if (property.getAttribute(VisibilityAttribute.class, VisibilityAttribute.STOP_NONE).isStopLookup()) {
          continue;
        }
        properties.add(property);
      }
    }

    return properties;
  }

  @Override
  public Optional<Property<?>> getFirst(PropertyKey<?>... keys) {
    List<Property<?>> properties = getProperties(keys);
    if (properties.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(properties.get(0));
  }
}
