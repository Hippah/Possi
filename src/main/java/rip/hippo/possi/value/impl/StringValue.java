package rip.hippo.possi.value.impl;

import rip.hippo.possi.value.callback.PropertyValueCallback;
import rip.hippo.possi.value.filter.FilterableValue;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 * <p>
 * A {@link FilterableValue} based around {@link String}s.
 */
public final class StringValue extends FilterableValue<String> {

  /**
   * The default <tt>value</tt>, an empty {@link String}.
   */
  public static final StringValue DEFAULT_VALUE = new StringValue("");
  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 3L;
  /**
   * The value.
   */
  private String value;

  /**
   * Constructs an <tt>StringValue</tt> with <tt>value</tt>.
   *
   * @param value The value.
   */
  public StringValue(String value) {
    this.value = value;
  }

  /**
   * A {@code static} wrapper for {@link StringValue#StringValue(String)}.
   *
   * @param value The value.
   * @return The new <tt>String Value</tt>
   */
  public static StringValue of(String value) {
    return new StringValue(value);
  }

  /**
   * @inheritDoc
   */
  @Override
  public PropertyValueCallback<String> update(String value) {
    String previous = this.value;
    boolean successful = passesFilters(value);
    if (successful) {
      this.value = value;
    }
    return new PropertyValueCallback<>(previous, value, successful);
  }

  /**
   * @inheritDoc
   */
  @Override
  public boolean parse(String value) {
    if (!passesFilters(value)) {
      return false;
    }
    this.value = value;
    return true;
  }

  /**
   * @inheritDoc
   */
  @Override
  public String get() {
    return value;
  }

  /**
   * Returns a {@link String} representation of the <tt>value</tt>.
   *
   * @return The representation.
   */
  @Override
  public String toString() {
    return "StringValue{" +
        "value='" + value + '\'' +
        '}';
  }
}
