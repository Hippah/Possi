package rip.hippo.possi.source;

import java.util.List;

/**
 * @author Hippo
 */
public interface PropertySource {
  void load();
  void save();

  void addBind(PropertyBind<?, ?> bind);
  List<PropertyBind<?, ?>> getBinds();
}
