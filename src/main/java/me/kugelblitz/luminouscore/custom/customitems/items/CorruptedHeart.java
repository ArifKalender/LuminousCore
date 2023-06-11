package me.kugelblitz.luminouscore.custom.customitems.items;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class CorruptedHeart {

    public static HashMap<Player, Boolean> healcd = new HashMap<Player, Boolean>();
    int i = 0;

    public CorruptedHeart(Player player) {

        if (healcd.get(player)) {
            player.sendMessage("§cThis ability is on cooldown.");
        }

        if (!healcd.get(player)) {

            if (player.getHealth() >= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.89) {
                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                player.sendMessage("§aYou healed yourself.");

            } else {
                player.setHealth(player.getHealth() + player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.10);
                player.sendMessage("§aYou healed yourself.");
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    i++;
                    healcd.put(player, true);
                    if (i >= 10) {
                        i = 0;
                        healcd.put(player, false);

                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 20);
        }
    }

}