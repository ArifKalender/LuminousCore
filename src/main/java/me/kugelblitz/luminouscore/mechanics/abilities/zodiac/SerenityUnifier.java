package me.kugelblitz.luminouscore.mechanics.abilities.zodiac;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class SerenityUnifier {
    public static HashMap<Player, Boolean> serenityUnifierCooldown = new HashMap<Player, Boolean>();
    private int i = 0;
    private int cd = 0;
    private Location location;

    public SerenityUnifier(Player player) {
        if (serenityUnifierCooldown.get(player) == null) {
            serenityUnifierCooldown.put(player, true);
            player.sendMessage("§aUsed SerenityUnifier!");

            new BukkitRunnable() {
                @Override

                public void run() {
                    i++;
                    if (i >= 10) {
                        this.cancel();
                    }

                    location = player.getLocation();
                    new UtilizationMethods().createSerenity(location, 7, Particle.TOTEM);
                    for (Entity entity : location.getWorld().getNearbyEntities(location, 6, 2, 6)) {
                        if (entity instanceof LivingEntity) {
                            new UtilizationMethods().createSerenity(entity.getLocation(), 1, Particle.HEART);
                            LivingEntity livingEntity = (LivingEntity) entity;

                            if (livingEntity.getHealth() <= livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.9) {
                                livingEntity.setHealth(livingEntity.getHealth() + livingEntity.getHealth() * 0.099);
                            } else {
                                livingEntity.setHealth(livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                            }
                        }
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 6 * 20);

            new BukkitRunnable() {
                @Override
                public void run() {
                    cd++;
                    if (cd >= 120) {
                        serenityUnifierCooldown.put(player, null);
                        player.sendMessage("§aSerenityUnifier is now available.");
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 20);
        } else {
            player.sendMessage("§cSerenityUnifier is currently on cooldown.");
        }
    }
}
