package rip.hippo.possi.value.callback;

import rip.hippo.possi.value.Value;

/**
 * @author Hippo
 * @version 3.0.0, 4/7/20
 * @since 3.0.0
 * <p>
 * An object that stores information about a {@link Value} being updated.
 */
public final class PropertyValueCallback<T> {

  /**
   * The previous and current value after the update.
   */
  private final T previous, current;

  /**
   * If the update was successful.
   */
  private final boolean successful;

  /**
   * Constructs a <tt>Property Value Callback</tt> with the desired previous and current values and if it was successful.
   *
   * @param previous   The previous value.
   * @param current    The current value.
   * @param successful If it was successful.
   */
  public PropertyValueCallback(T previous, T current, boolean successful) {
    this.previous = previous;
    this.current = current;
    this.successful = successful;
  }

  /**
   * Gets the previous value.
   *
   * @return The previous value.
   */
  public T getPrevious() {
    return previous;
  }

  /**
   * Gets the current value.
   *
   * @return The current value.
   */
  public T getCurrent() {
    return current;
  }

  /**
   * Gets if the update was successful.
   *
   * @return If it was successful.
   */
  public boolean isSuccessful() {
    return successful;
  }
}
