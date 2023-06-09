package me.kugelblitz.luminouscore.mechanics.abilities.deltus;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class MysticalSeal {
    public static HashMap<Player, Boolean> sealCooldown = new HashMap<Player, Boolean>();
    Location location;
    Location origin;
    int j = 0;
    Vector direction;

    public MysticalSeal(Player player) {

        if (sealCooldown.get(player) == null) {
            sealCooldown.put(player, true);
            location = player.getEyeLocation();
            origin = location.clone();
            direction = location.getDirection();
            new BukkitRunnable() {
                @Override
                public void run() {
                    j++;
                    if (!(location.distance(origin) >= 15)) {


                        UtilizationMethods.createSemiCircle(location, 0.3 * j, Particle.END_ROD, location.getDirection());
                        location.add(direction.multiply(1));
                        for (Entity entity : location.getWorld().getNearbyEntities(location, 2, 2, 2)) {
                            if (entity instanceof LivingEntity) {
                                if (entity != player) {
                                    ((LivingEntity) entity).damage(((LivingEntity) entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.05);
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 4, 15));
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 4, 15));
                                }
                            }
                        }
                    }
                    if (j >= 5 * 20) {
                        sealCooldown.put(player, null);
                        j = 0;
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);

        } else {
            player.sendMessage("§cMysticalSeal is currently on cooldown.");
        }
    }
}
