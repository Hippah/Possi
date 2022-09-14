package rip.hippo.possi.spigot.source.impl;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.spigot.source.YAMLPropertyBind;
import rip.hippo.possi.spigot.source.YAMLPropertySource;

/**
 * @author Hippo
 */
public final class PrimitiveYAMLPropertyBind<T> extends YAMLPropertyBind<T> {

  private final Class<T> type;

  public PrimitiveYAMLPropertyBind(YAMLPropertySource source, String path, Class<T> type) {
    super(source, path);
    this.type = type;
  }

  @Override
  public T read(ConfigurationSection section) {
    Object object = section.get(getPath());
    if (object != null && type.isAssignableFrom(object.getClass())) {
      return type.cast(object);
    }
    return null;
  }

  @Override
  public void write(ConfigurationSection section, T value) {
    section.set(getPath(), value);
  }
}
