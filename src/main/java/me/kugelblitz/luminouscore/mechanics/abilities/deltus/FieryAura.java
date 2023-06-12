package me.kugelblitz.luminouscore.mechanics.abilities.deltus;

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

public class FieryAura {
    public static HashMap<Player, Boolean> fieryAuraCooldown = new HashMap<Player, Boolean>();
    int i = 0;
    Location location;

    public FieryAura(Player player) {
        if (fieryAuraCooldown.get(player) == null) {
            location = player.getLocation();
            fieryAuraCooldown.put(player, true);
            new BukkitRunnable() {
                @Override
                public void run() {
                    i++;

                    if (i <= 4 * 6) {
                        UtilizationMethods.generateCircle(location, Particle.DRAGON_BREATH, 7);
                        for (Entity entity : location.getWorld().getNearbyEntities(location, 7, 2, 7)) {
                            if (entity instanceof LivingEntity) {
                                if (entity != player) {
                                    ((LivingEntity) entity).damage(((LivingEntity) entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.03);
                                    ((LivingEntity) entity).setNoDamageTicks(0);
                                }
                            }
                        }
                    }

                    if (i >= 4 * 90) {
                        i = 0;
                        fieryAuraCooldown.put(player, null);
                        player.sendMessage("§aFieryAura is now available.");
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 5);
        } else {
            player.sendMessage("§cFieryAura is currently on cooldown.");
        }
    }
}
