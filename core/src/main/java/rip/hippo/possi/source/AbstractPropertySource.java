package rip.hippo.possi.source;

import rip.hippo.possi.attribute.impl.VisibilityAttribute;

import java.util.ArrayList;
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
    List<PropertyBind<?, ?>> filterList = new ArrayList<>(binds);
    filterList.removeIf(bind -> bind.getProperty()
        .getAttribute(VisibilityAttribute.class, VisibilityAttribute.STOP_NONE).isStopSource());
    return filterList;
  }
}
