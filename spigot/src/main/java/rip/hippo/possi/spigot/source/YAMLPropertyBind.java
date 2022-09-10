package rip.hippo.possi.spigot.source;

import org.bukkit.configuration.ConfigurationSection;
import rip.hippo.possi.source.AbstractPropertyBind;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author Hippo
 */
public final class YAMLPropertyBind<T> extends AbstractPropertyBind<YAMLPropertySource, T> {

  private final Function<ConfigurationSection, T> readFunction;
  private final BiConsumer<ConfigurationSection, T> writeFunction;

  public YAMLPropertyBind(YAMLPropertySource source,
                          Function<ConfigurationSection, T> readFunction,
                          BiConsumer<ConfigurationSection, T> writeFunction) {
    super(source);
    this.readFunction = readFunction;
    this.writeFunction = writeFunction;
  }


  @Override
  public void onLoad() {
    T value = readFunction.apply(getSource().getYamlConfiguration());
    if (value != null) {
      getProperty().set(value);
    }
  }

  @Override
  public void onSave() {
    writeFunction.accept(getSource().getYamlConfiguration(), getProperty().get());
  }
}
