package me.kugelblitz.luminouscore.custom.custommobs.arcanehaven.active;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

//phantom type
//may change mob size
public class Nightmare {

    public Nightmare(Location location) {
        Phantom nightmare = (Phantom) location.getWorld().spawnEntity(location, EntityType.PHANTOM, false);
        nightmare.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50000);
        nightmare.setHealth(50000);
        nightmare.setCustomName("§4Nightmare §c[50000§e/§c50000]");
        nightmare.setCustomNameVisible(true);
        new BukkitRunnable() {
            @Override
            public void run() {
                nightmare.setCustomName("§4Nightmare §c[" + (int) nightmare.getHealth() + "§e/§c" + (int) nightmare.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + "]");
                UtilizationMethods.generateCircle(nightmare.getLocation(), Particle.DRAGON_BREATH, 3);
                for (Player player : UtilizationMethods.getNearbyPlayers(nightmare.getLocation(), 4)) {
                    player.damage(15, nightmare);
                    player.setNoDamageTicks(0);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, 20 * 12, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 12, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 12, 1));
                }

                if (nightmare.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 1);
    }

}
