package rip.hippo.possi.source;

import rip.hippo.possi.Property;
import java.util.Objects;

/**
 * @author Hippo
 */
public abstract class AbstractPropertyBind<T extends PropertySource, U> implements PropertyBind<T, U> {


  private final T source;
  private Property<U> property;

  public AbstractPropertyBind(T source) {
    this.source = source;
    source.addBind(this);
  }

  @Override
  public void setProperty(Property<U> property) {
    this.property = property;
  }

  @Override
  public Property<U> getProperty() {
    return Objects.requireNonNull(property, "Property is null");
  }

  @SuppressWarnings("unchecked")
  @Override
  public <S> Property<S> getProperty(Class<S> type) {
    Property<S> property = (Property<S>) getProperty();
    return Objects.requireNonNull(property, "Property is null");
  }

  @Override
  public T getSource() {
    return source;
  }

}
