package rip.hippo.possi.callback.impl;

import rip.hippo.possi.callback.ValueChangeCallback;
import rip.hippo.possi.callback.ValueChangeContext;

/**
 * @author Hippo
 */
public final class ClampCallback<T extends Number> implements ValueChangeCallback<T> {

  private final T min;
  private final T max;

  public ClampCallback(T min, T max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public void onChange(ValueChangeContext<T> context) {
    if (context.getNewValue().doubleValue() < min.doubleValue()) {
      context.setNewValue(min);
    } else if (context.getNewValue().doubleValue() > max.doubleValue()) {
      context.setNewValue(max);
    }
  }
}
