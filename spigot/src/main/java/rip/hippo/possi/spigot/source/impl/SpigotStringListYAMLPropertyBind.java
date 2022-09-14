package rip.hippo.possi.spigot.source.impl;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.spigot.SpigotStringList;
import rip.hippo.possi.spigot.source.YAMLPropertyBind;
import rip.hippo.possi.spigot.source.YAMLPropertySource;

/**
 * @author Hippo
 */
public final class SpigotStringListYAMLPropertyBind extends YAMLPropertyBind<SpigotStringList> {
  public SpigotStringListYAMLPropertyBind(YAMLPropertySource source, String path) {
    super(source, path);
  }

  @Override
  public SpigotStringList read(ConfigurationSection section) {
    if (section.isList(getPath())) {
      return new SpigotStringList(section.getStringList(getPath()));
    }
    return null;
  }

  @Override
  public void write(ConfigurationSection section, SpigotStringList value) {
    section.set(getPath(), value.toStringList());
  }
}
