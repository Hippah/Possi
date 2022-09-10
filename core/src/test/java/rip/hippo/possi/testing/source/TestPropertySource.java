package rip.hippo.possi.testing.source;

import rip.hippo.possi.source.AbstractPropertySource;
import rip.hippo.possi.source.PropertyBind;

import java.util.Properties;

/**
 * @author Hippo
 */
public final class TestPropertySource extends AbstractPropertySource {

  private final Properties properties;

  public TestPropertySource(Properties properties) {
    this.properties = properties;
  }

  @Override
  public void load() {
    for (PropertyBind<?, ?> bind : getBinds()) {
      bind.onLoad();
    }
  }

  @Override
  public void save() {
    for (PropertyBind<?, ?> bind : getBinds()) {
      bind.onSave();
    }
  }

  public TestPropertyBind<String> bindString(String path) {
    return new TestPropertyBind<>(this, path);
  }

  public TestPropertyBind<Integer> bindInt(String path) {
    return new TestPropertyBind<>(this, path);
  }

  public Properties getProperties() {
    return properties;
  }
}
