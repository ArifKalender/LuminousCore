package me.kugelblitz.luminouscore.statmanagement;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.PlayerStats;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class Regeneration {


    public static HashMap<Player, Double> mana = new HashMap<Player, Double>();
    public static HashMap<Player, Double> maxMana = new HashMap<Player, Double>();

    public void regenerate() {
        new BukkitRunnable() {

            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID uuid = player.getUniqueId();

                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(player.getLevel() * 7.5 + Double.valueOf((int) PlayerStats.getStats().get(uuid + ".Stats.Intelligence")));
                    Regeneration.maxMana.put(player, Double.valueOf((int) PlayerStats.getStats().get(uuid + ".Stats.Intelligence")));
                    PlayerStats.getStats().addDefault(uuid + ".Info.PlayerName", player.getName());

                    if (mana.get(player) == null) {
                        mana.put(player, 100.0);
                    }

                    if (maxMana.get(player) == null) {
                        maxMana.put(player, Double.valueOf((int) PlayerStats.getStats().get(uuid + ".Stats.Intelligence")));
                    }

                    if (mana.get(player) == null) {
                        mana.put(player, 100.0);
                    }

                    if (maxMana.get(player) == null) {
                        maxMana.put(player, Double.valueOf((int) PlayerStats.getStats().get(uuid + ".Stats.Intelligence")));
                    }

                    if (mana.get(player) >= maxMana.get(player) * 0.98) {
                        mana.put(player, maxMana.get(player));
                    } else if (mana.get(player) < maxMana.get(player) * 0.98) {
                        mana.put(player, mana.get(player) + maxMana.get(player) * 0.02);
                        mana.put(player, maxMana.get(player));
                    } else if (mana.get(player) < maxMana.get(player) * 0.98) {
                        mana.put(player, mana.get(player) + maxMana.get(player) * 0.02);
                    }

                    //health regen v mana regen ^
                    if (!player.isDead()) {
                        if (player.getHealth() >= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.98) {
                            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                        } else {
                            player.setHealth(player.getHealth() + player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.01);
                        }
                    }
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 20, 20);
    }

    public void indicate() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID uuid = player.getUniqueId();
                    String health = String.valueOf((int) player.getHealth());
                    String maxHealth = String.valueOf((int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    if (mana.get(player) == null) {
                        mana.put(player, 100.0);
                    }
                    int manaInt = (int) mana.get(player).doubleValue();
                    int maxMana = (int) PlayerStats.getStats().get(uuid + ".Stats.Intelligence");
                    String text = "§cHealth: " + health + "§4/§c" + maxHealth + "        §bMana: " + manaInt + "§9/" + "§b" + maxMana;
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 20, 20);
    }
}
