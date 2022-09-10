package rip.hippo.possi.source;

import rip.hippo.possi.Property;


/**
 * @author Hippo
 */
public interface PropertyBind<T extends PropertySource, U> {
  void onLoad();
  void onSave();

  void setProperty(Property<U> property);
  Property<U> getProperty();
  <S> Property<S> getProperty(Class<S> type);

  T getSource();
}
