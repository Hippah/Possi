package rip.hippo.possi.spigot.source.impl;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.spigot.source.YAMLPropertyBind;
import rip.hippo.possi.spigot.source.YAMLPropertySource;

/**
 * @author Hippo
 */
public final class PrimitiveYAMLPropertyBind<T> extends YAMLPropertyBind<T> {


  public PrimitiveYAMLPropertyBind(YAMLPropertySource source, String path) {
    super(source, path);
  }

  @Override @SuppressWarnings("unchecked")
  public T read(ConfigurationSection section) {
    Object object = section.get(getPath());
    return (T) object;
  }

  @Override
  public void write(ConfigurationSection section, T value) {
    section.set(getPath(), value);
  }
}
