package rip.hippo.possi.key.impl;

import rip.hippo.possi.key.PropertyKey;

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
}
