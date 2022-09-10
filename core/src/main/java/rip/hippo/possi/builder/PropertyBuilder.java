package rip.hippo.possi.builder;

import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.PropertyAttribute;
import rip.hippo.possi.callback.ValueChangeCallback;
import rip.hippo.possi.callback.ValueChangeContext;
import rip.hippo.possi.key.PropertyKey;
import rip.hippo.possi.key.PropertyKeyRegistry;
import rip.hippo.possi.source.PropertyBind;

import java.util.*;

/**
 * @author Hippo
 */
public final class PropertyBuilder<T> implements Property<T> {

  private T value;
  private final List<ValueChangeCallback<T>> callbacks;
  private final Map<Class<?>, PropertyKey<?>> keyMap;
  private final Map<Class<?>, PropertyAttribute> attributeMap;

  public PropertyBuilder(T value) {
    this.value = value;
    this.callbacks = new LinkedList<>();
    this.keyMap = new HashMap<>();
    this.attributeMap = new HashMap<>();
  }

  public PropertyBuilder<T> withCallback(ValueChangeCallback<T> callback) {
    callbacks.add(callback);
    return this;
  }

  public PropertyBuilder<T> withKey(PropertyKeyRegistry keyRegistry, PropertyKey<?> key) {
    keyRegistry.register(key, this);
    keyMap.put(key.getClass(), key);
    return this;
  }

  public PropertyBuilder<T> withAttribute(PropertyAttribute attribute) {
    attributeMap.put(attribute.getClass(), attribute);
    attribute.setProperty(this);
    return this;
  }

  public PropertyBuilder<T> withBind(PropertyBind<?, T> bind) {
    bind.setProperty(this);
    return this;
  }

  @Override
  public T get() {
    return value;
  }

  @Override
  public void set(T value) {
    ValueChangeContext<T> valueChangeContext = new ValueChangeContext<>(this.value, value);
    for (ValueChangeCallback<T> callback : callbacks) {
      callback.onChange(valueChangeContext);
    }
    if (valueChangeContext.isCancelled()) {
      return;
    }
    this.value = valueChangeContext.getNewValue();
  }

  @Override
  public <U extends PropertyAttribute> Optional<U> getAttribute(Class<U> attributeClass) {
    return Optional.ofNullable(attributeMap.get(attributeClass)).map(attributeClass::cast);
  }

  @Override
  public List<PropertyAttribute> getAttributes() {
    return new ArrayList<>(attributeMap.values());
  }

  @Override
  public <U extends PropertyKey<?>> Optional<U> getKey(Class<U> keyClass) {
    return Optional.ofNullable(keyMap.get(keyClass)).map(keyClass::cast);
  }

  @Override
  public List<PropertyKey<?>> getKeys() {
    return new ArrayList<>(keyMap.values());
  }

  @Override
  public List<ValueChangeCallback<T>> getCallbacks() {
    return callbacks;
  }

  @Override
  public String toString() {
    return "Property{" +
        "value=" + value +
        '}';
  }
}
