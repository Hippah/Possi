package rip.hippo.possi.reflector;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Hippo
 */
public final class Reflector {

  @SuppressWarnings("unchecked")
  public static <T> Class<List<T>> getListClass(Class<T> type) {
    return (Class<List<T>>) (Class<?>) List.class;
  }

  @SuppressWarnings("unchecked")
  public static Class<List<?>> getWildCardList() {
    return (Class<List<?>>) (Class<?>) List.class;
  }

  @SuppressWarnings("unchecked")
  public static <T> Class<Set<T>> getSetClass(Class<T> type) {
    return (Class<Set<T>>) (Class<?>) Set.class;
  }

  @SuppressWarnings("unchecked")
  public static Class<Set<?>> getWildCardSet() {
    return (Class<Set<?>>) (Class<?>) Set.class;
  }

  @SuppressWarnings("unchecked")
  public static <K, V> Class<Map<K, V>> getMapClass(Class<K> keyType, Class<V> valueType) {
    return (Class<Map<K, V>>) (Class<?>) Map.class;
  }

  @SuppressWarnings("unchecked")
  public static <K> Class<Map<K, ?>> getWildCardValueMap(Class<K> keyType) {
    return (Class<Map<K, ?>>) (Class<?>) Map.class;
  }

  @SuppressWarnings("unchecked")
  public static <V> Class<Map<?, V>> getWildCardKeyMap(Class<V> valueType) {
    return (Class<Map<?, V>>) (Class<?>) Map.class;
  }

  @SuppressWarnings("unchecked")
  public static Class<Map<?, ?>> getWildCardMap() {
    return (Class<Map<?, ?>>) (Class<?>) Map.class;
  }
}
