package rip.hippo.possi.spigot.source;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import rip.hippo.possi.reflector.Reflector;
import rip.hippo.possi.source.AbstractPropertySource;
import rip.hippo.possi.source.PropertyBind;
import rip.hippo.possi.spigot.SpigotString;
import rip.hippo.possi.spigot.SpigotStringList;
import rip.hippo.possi.spigot.source.impl.PrimitiveYAMLPropertyBind;
import rip.hippo.possi.spigot.source.impl.SpigotStringListYAMLPropertyBind;
import rip.hippo.possi.spigot.source.impl.SpigotStringYAMLPropertyBind;

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
    return new SpigotStringYAMLPropertyBind(this, path);
  }

  public YAMLPropertyBind<String> bindString(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, String.class);
  }

  public YAMLPropertyBind<Integer> bindInteger(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Integer.class);
  }

  public YAMLPropertyBind<Boolean> bindBoolean(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Boolean.class);
  }

  public YAMLPropertyBind<Double> bindDouble(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Double.class);
  }

  public YAMLPropertyBind<Long> bindLong(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Long.class);
  }

  public YAMLPropertyBind<List<?>> getList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getWildCardList());
  }

  public YAMLPropertyBind<SpigotStringList> getSpigotStringList(String path) {
    return new SpigotStringListYAMLPropertyBind(this, path);
  }

  public YAMLPropertyBind<List<String>> bindStringList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(String.class));
  }

  public YAMLPropertyBind<List<Integer>> bindIntegerList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Integer.class));
  }

  public YAMLPropertyBind<List<Boolean>> bindBooleanList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Boolean.class));
  }

  public YAMLPropertyBind<List<Double>> bindDoubleList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Double.class));
  }

  public YAMLPropertyBind<List<Float>> bindFloatList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Float.class));
  }

  public YAMLPropertyBind<List<Long>> bindLongList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Long.class));
  }

  public YAMLPropertyBind<List<Byte>> bindByteList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Byte.class));
  }

  public YAMLPropertyBind<List<Character>> bindCharacterList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Character.class));
  }

  public YAMLPropertyBind<List<Short>> bindShortList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Short.class));
  }

  public YAMLPropertyBind<List<Map<?, ?>>> bindMapList(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Reflector.getListClass(Reflector.getWildCardMap()));
  }

  public YAMLPropertyBind<Vector> bindVector(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Vector.class);
  }

  public YAMLPropertyBind<OfflinePlayer> bindOfflinePlayer(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, OfflinePlayer.class);
  }

  public YAMLPropertyBind<ItemStack> bindItemStack(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, ItemStack.class);
  }

  public YAMLPropertyBind<Color> bindColor(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Color.class);
  }

  public YAMLPropertyBind<Location> bindLocation(String path) {
    return new PrimitiveYAMLPropertyBind<>(this, path, Location.class);
  }

  public YamlConfiguration getYamlConfiguration() {
    return yamlConfiguration;
  }

  public File getFile() {
    return file;
  }
}
