package rip.hippo.possi.key.impl;

import rip.hippo.possi.key.PropertyKey;

import java.util.Objects;

/**
 * @author Hippo
 */
public abstract class AbstractImmutablePropertyKey<T> implements PropertyKey<T> {

  private final T value;

  public AbstractImmutablePropertyKey(T value) {
    this.value = value;
  }

  @Override
  public T getKeyValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractImmutablePropertyKey<?> that = (AbstractImmutablePropertyKey<?>) o;

    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
