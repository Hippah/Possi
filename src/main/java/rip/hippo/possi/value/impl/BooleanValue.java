package rip.hippo.possi.value.impl;

import rip.hippo.possi.value.Value;
import rip.hippo.possi.value.callback.PropertyValueCallback;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 * <p>
 * A {@link Value} based on {@link Boolean}s.
 */
public final class BooleanValue implements Value<Boolean> {

  /**
   * The default <tt>value</tt> with a {@code false} <tt>value</tt>
   */
  public static final BooleanValue DEFAULT_VALUE = new BooleanValue(false);
  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 3L;
  /**
   * Mappings from common {@link String} values to their corresponding {@link Boolean} value.
   */
  private static final Map<String, Boolean> BOOLEAN_MAPPINGS = Map.of(
      "true", true,
      "on", true,
      "enabled", true,

      "false", false,
      "off", false,
      "disabled", false
  );

  /**
   * The value.
   */
  private Boolean value;

  /**
   * Constructs a <tt>Boolean Value</tt> with <tt>value</tt>.
   *
   * @param value The value.
   */
  public BooleanValue(Boolean value) {
    this.value = value;
  }

  /**
   * A {@code static} wrapper for {@link BooleanValue#BooleanValue(Boolean)}.
   *
   * @param value The value.
   * @return The new <tt>Boolean Value</tt>
   */
  public static BooleanValue of(Boolean value) {
    return new BooleanValue(value);
  }

  /**
   * Inverses the boolean value.
   *
   * @return The callback after the inverse.
   */
  public PropertyValueCallback<Boolean> inverse() {
    return update(!value);
  }

  /**
   * @inheritDoc
   */
  @Override
  public PropertyValueCallback<Boolean> update(Boolean value) {
    this.value = value;
    return new PropertyValueCallback<>(!value, value, true);
  }

  /**
   * @inheritDoc
   */
  @Override
  public boolean parse(String value) {
    Boolean parsed = BOOLEAN_MAPPINGS.get(value);
    if (parsed == null) {
      return false;
    }
    this.value = parsed;
    return true;
  }

  /**
   * @inheritDoc
   */
  @Override
  public Boolean get() {
    return value;
  }

  /**
   * Returns a {@link String} representation of the <tt>value</tt>.
   *
   * @return The representation.
   */
  @Override
  public String toString() {
    return "BooleanValue{" +
        "value=" + value +
        '}';
  }
}
