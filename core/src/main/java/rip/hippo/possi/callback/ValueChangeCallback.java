package rip.hippo.possi.callback;

/**
 * @author Hippo
 */
@FunctionalInterface
public interface ValueChangeCallback<T> {
  void onChange(ValueChangeContext<T> context);
}
