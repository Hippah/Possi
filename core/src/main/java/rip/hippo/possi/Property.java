package rip.hippo.possi;

import rip.hippo.possi.attribute.PropertyAttribute;
import rip.hippo.possi.builder.PropertyBuilder;
import rip.hippo.possi.builder.PropertyValueBuilder;
import rip.hippo.possi.callback.ValueChangeCallback;
import rip.hippo.possi.key.PropertyKey;

import java.util.List;
import java.util.Optional;

/**
 * @author Hippo
 */
public interface Property<T> {

  T get();
  void set(T value);

  <U extends PropertyAttribute> Optional<U> getAttribute(Class<U> attributeClass);
  <U extends PropertyAttribute> U getAttribute(Class<U> attributeClass, U defaultValue);
  List<PropertyAttribute> getAttributes();

  <U extends PropertyKey<?>> Optional<U> getKey(Class<U> keyClass);
  List<PropertyKey<?>> getKeys();

  List<ValueChangeCallback<T>> getCallbacks();

  static <U> PropertyValueBuilder<U> of(Class<U> type) {
    return new PropertyValueBuilder<>(type);
  }

  static <U> PropertyBuilder<U> as(U value) {
    return new PropertyBuilder<>(value);
  }
}
