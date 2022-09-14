package rip.hippo.possi.spigot.source;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.source.AbstractPropertyBind;

/**
 * @author Hippo
 */
public abstract class YAMLPropertyBind<T> extends AbstractPropertyBind<YAMLPropertySource, T> {

  private final String path;

  public YAMLPropertyBind(YAMLPropertySource source, String path) {
    super(source);
    this.path = path;
  }

  public abstract T read(ConfigurationSection section);
  public abstract void write(ConfigurationSection section, T value);

  @Override
  public void onLoad() {
    T value = read(getSource().getYamlConfiguration());
    if (value != null) {
      getProperty().set(value);
    }
  }

  @Override
  public void onSave() {
    write(getSource().getYamlConfiguration(), getProperty().get());
  }

  public String getPath() {
    return path;
  }
}
