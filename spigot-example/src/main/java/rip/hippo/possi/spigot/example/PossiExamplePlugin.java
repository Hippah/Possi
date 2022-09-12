package rip.hippo.possi.spigot.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import rip.hippo.possi.Property;
import rip.hippo.possi.spigot.SpigotString;
import rip.hippo.possi.spigot.source.YAMLPropertySource;

import java.util.Objects;

/**
 * @author Hippo
 */
public final class PossiExamplePlugin extends JavaPlugin {

  private final YAMLPropertySource propertySource = new YAMLPropertySource(this);

  private final Property<SpigotString> greetingProperty = Property.of(SpigotString.of("&cHello world!").color())
      .withBind(propertySource.bindSpigotString("messages.greeting"));

  @Override
  public void onEnable() {
    saveDefaultConfig();
    propertySource.load();

    Objects.requireNonNull(Bukkit.getPluginCommand("possi")).setExecutor(this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (args.length == 0) {
      greetingProperty.get()
          .copy()
          .color()
          .replace("%name%", sender.getName())
          .send(sender);
      return true;
    }

    if (args.length == 1 && args[0].equals("reload")) {
      Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
        reloadConfig();
        propertySource.load();
        sender.sendMessage("Reloaded!");
      });
      return true;
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (String arg : args) {
      stringBuilder.append(arg).append(" ");
    }
    String newGreeting = stringBuilder.toString().trim();

    greetingProperty.set(SpigotString.of(newGreeting));
    SpigotString.of("&aGreeting set to: &e" + newGreeting).color().send(sender);

    Bukkit.getScheduler().runTaskAsynchronously(this, propertySource::save);
    return true;
  }
}
