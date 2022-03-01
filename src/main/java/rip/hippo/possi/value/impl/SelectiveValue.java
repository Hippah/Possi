package rip.hippo.possi.value.impl;

import rip.hippo.possi.value.callback.PropertyValueCallback;
import rip.hippo.possi.value.filter.FilterableValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> The type of the selections.
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 * <p>
 * A {@link FilterableValue} based around having selections of <tt>T</tt>.
 */
public final class SelectiveValue<T> extends FilterableValue<T> {

  /**
   * The serial id.
   *
   * @see Serializable
   */
  @Serial
  private static final long serialVersionUID = 2L;

  /**
   * A {@link List} of possible <tt>selections</tt>
   */
  private final List<T> selections;

  /**
   * The {@code index} of the current <tt>selection</tt>.
   */
  private int selected;

  /**
   * Constructs a <tt>Selective Value</tt> with no <tt>selections</tt> by default.
   */
  public SelectiveValue() {
    this.selections = new ArrayList<>();
  }

  /**
   * adds <tt>selection</tt> to {@link SelectiveValue#selections}.
   *
   * <p>
   * Will check if <tt>selection</tt> passes the <tt>filters</tt>.
   * </p>
   *
   * @param selection The selection.
   * @see FilterableValue#passesFilters(Object)
   */
  public void add(T selection) {
    if (passesFilters(selection)) {
      selections.add(selection);
    }
  }

  /**
   * @inheritDoc
   */
  @Override
  public PropertyValueCallback<T> update(T value) {
    int index = selections.indexOf(value);
    T previous = get();
    boolean success = passesFilters(value) && index == -1;
    if (success) {
      selected = index;
    }
    return new PropertyValueCallback<>(previous, get(), success);
  }

  /**
   * @inheritDoc
   */
  @Override
  public boolean parse(String value) {
    boolean found = false;
    for (int i = 0; i < selections.size(); i++) {
      T selection = selections.get(i);
      if (selection.toString().equals(value)) {
        selected = i;
        found = true;
        break;
      }
    }
    return found;
  }

  /**
   * @inheritDoc
   */
  @Override
  public T get() {
    return selections.get(selected);
  }

  /**
   * Gets {@link SelectiveValue#selections}.
   *
   * @return The selections.
   */
  public List<T> getSelections() {
    return selections;
  }

  /**
   * Returns a {@link String} representation of the <tt>value</tt>.
   *
   * @return The representation.
   */
  @Override
  public String toString() {
    return "SelectiveValue{" +
        "selections=" + selections +
        '}';
  }
}
