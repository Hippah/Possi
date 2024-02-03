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
import rip.hippo.possi.spigot.source.impl.PrimitiveYAMLPropertyBind;
import rip.hippo.possi.spigot.source.impl.SpigotStringListYAMLPropertyBind;
import rip.hippo.possi.spigot.source.impl.SpigotStringYAMLPropertyBind;

import java.io.File;
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
    return new SpigotStringYAMLPropertyBind(this, path);
  }

  public YAMLPropertyBind<String> bindString(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Integer> bindInteger(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Boolean> bindBoolean(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Double> bindDouble(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Long> bindLong(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<?>> getList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<SpigotStringList> getSpigotStringList(String path) {
    return new SpigotStringListYAMLPropertyBind(this, path);
  }

  public YAMLPropertyBind<List<String>> bindStringList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Integer>> bindIntegerList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Boolean>> bindBooleanList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Double>> bindDoubleList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Float>> bindFloatList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Long>> bindLongList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Byte>> bindByteList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Character>> bindCharacterList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Short>> bindShortList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<List<Map<?, ?>>> bindMapList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Vector> bindVector(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<OfflinePlayer> bindOfflinePlayer(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<ItemStack> bindItemStack(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Color> bindColor(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YAMLPropertyBind<Location> bindLocation(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path);
  }

  public YamlConfiguration getYamlConfiguration() {
    return yamlConfiguration;
  }

  public File getFile() {
    return file;
  }
}
