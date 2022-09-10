package rip.hippo.possi.testing.source;

import rip.hippo.possi.source.AbstractPropertyBind;

/**
 * @author Hippo
 */
public final class TestPropertyBind<T> extends AbstractPropertyBind<TestPropertySource, T> {
  private final String path;

  public TestPropertyBind(TestPropertySource source, String path) {
    super(source);
    this.path = path;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void onLoad() {
    getProperty().set((T) getSource().getProperties().get(path));
  }

  @Override
  public void onSave() {
    getSource().getProperties().put(path, getProperty().get());
  }
}
