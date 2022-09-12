package rip.hippo.possi;

import rip.hippo.possi.attribute.PropertyAttribute;
import rip.hippo.possi.internal.StandardProperty;
import rip.hippo.possi.callback.ValueChangeCallback;
import rip.hippo.possi.key.PropertyKey;
import rip.hippo.possi.key.PropertyKeyRegistry;
import rip.hippo.possi.source.PropertyBind;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Hippo
 */
public interface Property<T> {

  Property<T> withCallback(ValueChangeCallback<T> callback);
  Property<T> withKey(PropertyKeyRegistry keyRegistry, PropertyKey<?> key);
  Property<T> withAttribute(PropertyAttribute attribute);
  Property<T> withBind(PropertyBind<?, T> bind);
  T get();
  void set(T value);

  <U extends PropertyAttribute> Optional<U> getAttribute(Class<U> attributeClass);
  <U extends PropertyAttribute> U getAttribute(Class<U> attributeClass, U defaultValue);
  List<PropertyAttribute> getAttributes();

  <U extends PropertyKey<?>> Optional<U> getKey(Class<U> keyClass);
  List<PropertyKey<?>> getKeys();

  List<ValueChangeCallback<T>> getCallbacks();

  static <U> Property<U> of(U value) {
    return new StandardProperty<>(value);
  }

  static <U> Property<U> of(Supplier<U> supplier) {
    return of(supplier.get());
  }
}
