package rip.hippo.possi.attribute.impl;

import rip.hippo.possi.attribute.AbstractPropertyAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hippo
 */
public final class SelectiveAttribute<T> extends AbstractPropertyAttribute {

  private final List<T> values;
  private int index;

  public SelectiveAttribute(List<T> values) {
    this.values = values;
    this.index = 0;
  }

  @SafeVarargs
  public SelectiveAttribute(T... values) {
    this(Arrays.asList(values));
  }

  public T current() {
    index = checkBounds(index);
    return values.get(index);
  }

  public T next() {
    index = checkBounds(index + 1);
    return values.get(index);
  }

  public T previous() {
    index = checkBounds(index - 1);
    return values.get(index);
  }

  public List<T> getValues() {
    return values;
  }

  public int getIndex() {
    return index;
  }

  private int checkBounds(int index) {
    return Math.min(Math.max(index, 0), values.size() - 1);
  }
}
