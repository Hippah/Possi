package rip.hippo.possi.spigot;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hippo
 */
public final class SpigotStringList extends ArrayList<SpigotString> {


  public SpigotStringList(List<String> list) {
    for (String s : list) {
      add(SpigotString.of(s));
    }
  }

  public SpigotStringList color() {
    replaceAll(SpigotString::color);
    return this;
  }

  public SpigotStringList papi(OfflinePlayer player) {
    replaceAll(string -> string.papi(player));
    return this;
  }

  public SpigotStringList papi(Player player) {
    replaceAll(string -> string.papi(player));
    return this;
  }

  public SpigotStringList replace(String key, String value) {
    replaceAll(string -> string.replace(key, value));
    return this;
  }

  public SpigotStringList send(CommandSender sender) {
    forEach(string -> string.send(sender));
    return this;
  }

  public List<String> toStringList() {
    List<String> list = new ArrayList<>(size());
    forEach(string -> list.add(string.getValue()));
    return list;
  }
}
