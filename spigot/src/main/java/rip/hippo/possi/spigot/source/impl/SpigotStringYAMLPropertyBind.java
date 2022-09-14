package rip.hippo.possi.spigot.source.impl;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.spigot.SpigotString;
import rip.hippo.possi.spigot.source.YAMLPropertyBind;
import rip.hippo.possi.spigot.source.YAMLPropertySource;

/**
 * @author Hippo
 */
public final class SpigotStringYAMLPropertyBind extends YAMLPropertyBind<SpigotString> {

  public SpigotStringYAMLPropertyBind(YAMLPropertySource source, String path) {
    super(source, path);
  }

  @Override
  public SpigotString read(ConfigurationSection section) {
    if (section.isString(getPath())) {
      return SpigotString.of(section.getString(getPath()));
    }
    return null;
  }

  @Override
  public void write(ConfigurationSection section, SpigotString value) {
    section.set(getPath(), value.getValue());
  }
}
