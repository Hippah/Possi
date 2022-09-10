package rip.hippo.possi.callback;

/**
 * @author Hippo
 */
public final class ValueChangeContext<T> {

  private final T oldValue;
  private T newValue;
  private boolean cancelled;

  public ValueChangeContext(T oldValue, T newValue) {
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.cancelled = false;
  }

  public T getOldValue() {
    return oldValue;
  }

  public T getNewValue() {
    return newValue;
  }

  public void setNewValue(T newValue) {
    this.newValue = newValue;
  }

  public boolean isCancelled() {
    return cancelled;
  }

  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}
