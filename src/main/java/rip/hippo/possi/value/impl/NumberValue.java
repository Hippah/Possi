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
 * A {@link FilterableValue} based around {@link Number}s.
 */
public final class NumberValue extends FilterableValue<Number> {

  /**
   * The default <tt>value</tt> with the numeric value being <tt>0</tt>.
   */
  public static final NumberValue DEFAULT_VALUE = new NumberValue(0);
  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 3L;
  /**
   * The value,
   * increment (how much the value will be incremented or decremented by)
   * minimum (the minimum value the value can be)
   * maximum (the maximum value the value can be)
   */
  private Number value, increment, minimum, maximum;

  /**
   * Constructs a <tt>Number Value</tt> with <tt>value</tt>.
   *
   * @param value The numeric value.
   */
  public NumberValue(Number value) {
    this.value = value;
    this.increment = 1;
    this.minimum = Double.MIN_VALUE;
    this.maximum = Double.MAX_VALUE;
    addFilter(number -> number.doubleValue() >= minimum.doubleValue() && number.doubleValue() <= maximum.doubleValue());
  }

  /**
   * A {@code static} wrapper for {@link NumberValue#NumberValue(Number)}.
   *
   * @param value The value.
   * @return The new <tt>Number Value</tt>
   */
  public static NumberValue of(Number value) {
    return new NumberValue(value);
  }

  /**
   * Increments the value, ensures it wont go over the maximum.
   */
  public void increment() {
    update(Math.min(maximum.doubleValue(), value.doubleValue() + increment.doubleValue()));
  }

  /**
   * Decrements the value, ensures it wont go under the minimum.
   */
  public void decrement() {
    update(Math.max(minimum.doubleValue(), value.doubleValue() - increment.doubleValue()));
  }

  /**
   * @inheritDoc
   */
  @Override
  public PropertyValueCallback<Number> update(Number value) {
    Number previous = this.value;
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
    try {
      double parsed = Double.parseDouble(value);
      if (!passesFilters(parsed)) {
        return false;
      }
      this.value = parsed;
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * @inheritDoc
   */
  @Override
  public Number get() {
    return value;
  }

  /**
   * Gets the increment.
   *
   * @return The increment.
   */
  public Number getIncrement() {
    return increment;
  }

  /**
   * Sets the increment to <tt>increment</tt>.
   *
   * <p>
   * no affect if <tt>increment</tt> is {@code null}.
   * </p>
   *
   * @param increment The increment to set to.
   */
  public void setIncrement(Number increment) {
    if (increment != null) {
      this.increment = increment;
    }
  }

  /**
   * Gets the minimum.
   *
   * @return The minimum.
   */
  public Number getMinimum() {
    return minimum;
  }

  /**
   * Sets the minimum to <tt>minimum</tt>.
   *
   * <p>
   * no affect if <tt>minimum</tt> is {@code null}.
   * </p>
   *
   * @param minimum The minimum to set to.
   */
  public void setMinimum(Number minimum) {
    if (minimum != null) {
      this.minimum = minimum;
    }
  }

  /**
   * Gets the maximum.
   *
   * @return The maximum.
   */
  public Number getMaximum() {
    return maximum;
  }

  /**
   * Sets the maximum to <tt>maximum</tt>.
   *
   * <p>
   * no affect if <tt>maximum</tt> is {@code null}.
   * </p>
   *
   * @param maximum The maximum to set to.
   */
  public void setMaximum(Number maximum) {
    if (maximum != null) {
      this.maximum = maximum;
    }
  }

  /**
   * Returns a {@link String} representation of the <tt>value</tt>.
   *
   * @return The representation.
   */
  @Override
  public String toString() {
    return "NumberValue{" +
        "value=" + value +
        ", increment=" + increment +
        ", minimum=" + minimum +
        ", maximum=" + maximum +
        '}';
  }
}
