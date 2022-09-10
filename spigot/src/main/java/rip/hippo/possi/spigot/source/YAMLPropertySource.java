package rip.hippo.possi.spigot.source;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import rip.hippo.possi.source.AbstractPropertySource;
import rip.hippo.possi.source.PropertyBind;
import rip.hippo.possi.spigot.SpigotString;
import rip.hippo.possi.spigot.SpigotStringList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hippo
 */
public final class YAMLPropertySource extends AbstractPropertySource {

  private final File file;
  private YamlConfiguration yamlConfiguration;

  public YAMLPropertySource(File file) {
    this.file = file;
    this.yamlConfiguration = new YamlConfiguration();
  }

  public YAMLPropertySource(JavaPlugin javaPlugin) {
    this(new File(javaPlugin.getDataFolder(), "config.yml"));

    if (!javaPlugin.getDataFolder().exists() && !javaPlugin.getDataFolder().mkdirs()) {
      throw new RuntimeException("Failed to create data folder");
    }
  }

  @Override
  public void load() {
    try {
      if (!file.exists()) {
        return;
      }
      yamlConfiguration = YamlConfiguration.loadConfiguration(file);

      for (PropertyBind<?, ?> bind : getBinds()) {
        bind.onLoad();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void save() {
    try {
      for (PropertyBind<?, ?> bind : getBinds()) {
        bind.onSave();
      }
      yamlConfiguration.save(file);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public YAMLPropertyBind<SpigotString> bindSpigotString(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isString(path)) {
        return SpigotString.of(section.getString(path));
      }
      return null;
    }, (section, value) -> section.set(path, value.getValue()));
  }

  public YAMLPropertyBind<String> bindString(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isString(path)) {
        return section.getString(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Integer> bindInteger(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isInt(path)) {
        return section.getInt(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Boolean> bindBoolean(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isBoolean(path)) {
        return section.getBoolean(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Double> bindDouble(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isDouble(path)) {
        return section.getDouble(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Long> bindLong(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isLong(path)) {
        return section.getLong(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<?>> getList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<SpigotStringList> getSpigotStringList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return new SpigotStringList(section.getStringList(path));
      }
      return null;
    }, (section, value) -> section.set(path, value.toStringList()));
  }

  public YAMLPropertyBind<List<String>> bindStringList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getStringList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Integer>> bindIntegerList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getIntegerList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Boolean>> bindBooleanList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getBooleanList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Double>> bindDoubleList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getDoubleList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Float>> bindFloatList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getFloatList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Long>> bindLongList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getLongList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Byte>> bindByteList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getByteList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Character>> bindCharacterList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getCharacterList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Short>> bindShortList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getShortList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<List<Map<?, ?>>> bindMapList(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isList(path)) {
        return section.getMapList(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Vector> bindVector(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isVector(path)) {
        return section.getVector(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<OfflinePlayer> bindOfflinePlayer(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isOfflinePlayer(path)) {
        return section.getOfflinePlayer(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<ItemStack> bindItemStack(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isItemStack(path)) {
        return section.getItemStack(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Color> bindColor(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isColor(path)) {
        return section.getColor(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YAMLPropertyBind<Location> bindLocation(String path) {
    return new YAMLPropertyBind<>(this, section -> {
      if (section.isConfigurationSection(path)) {
        return section.getLocation(path);
      }
      return null;
    }, (section, value) -> section.set(path, value));
  }

  public YamlConfiguration getYamlConfiguration() {
    return yamlConfiguration;
  }

  public File getFile() {
    return file;
  }
}
