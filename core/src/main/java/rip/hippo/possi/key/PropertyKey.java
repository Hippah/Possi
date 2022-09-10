package rip.hippo.possi.key;

/**
 * @author Hippo
 */
@FunctionalInterface
public interface PropertyKey<T> {
  T getKeyValue();
}
