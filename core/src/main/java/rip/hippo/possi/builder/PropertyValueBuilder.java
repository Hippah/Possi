package rip.hippo.possi.builder;

/**
 * @author Hippo
 */
public final class PropertyValueBuilder<T> {

  public PropertyValueBuilder(Class<T> type) {}

  public PropertyBuilder<T> with(T value) {
    return new PropertyBuilder<>(value);
  }
}
