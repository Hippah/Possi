package rip.hippo.possi.spigot;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.hippo.translate.ChatTranslate;

/**
 * @author Hippo
 */
public final class SpigotString {
  private String value;

  private SpigotString(String value) {
    this.value = value;
  }

  public SpigotString color() {
    value = ChatTranslate.translate(value);
    return this;
  }

  public SpigotString papi(OfflinePlayer player) {
    value = PlaceholderAPI.setPlaceholders(player, value);
    return this;
  }

  public SpigotString replace(String key, String value) {
    this.value = this.value.replace(key, value);
    return this;
  }

  public SpigotString send(CommandSender sender) {
    sender.sendMessage(value);
    return this;
  }

  public SpigotString copy() {
    return of(value);
  }

  public String getValue() {
    return value;
  }

  public static SpigotString of(String value) {
    if (value == null) {
      value = "";
    }
    return new SpigotString(value);
  }
}
