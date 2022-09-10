package rip.hippo.possi.source;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hippo
 */
public abstract class AbstractPropertySource implements PropertySource {

  private List<PropertyBind<?, ?>> binds = new LinkedList<>();

  @Override
  public void addBind(PropertyBind<?, ?> bind) {
    binds.add(bind);
  }

  @Override
  public List<PropertyBind<?, ?>> getBinds() {
    return binds;
  }
}
