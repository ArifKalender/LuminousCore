package me.kugelblitz.luminouscore.mechanics.abilities.siderealist;

import me.kugelblitz.luminouscore.LuminousCore;
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


public class CelestialVitality {
    Location location;
    Location origin;
    Vector direction;
    int j=0;
    public static HashMap<Player,Boolean> vitalityCooldown = new HashMap<Player,Boolean>();
    public CelestialVitality(Player player) {
        if(vitalityCooldown.get(player)==null) {
            vitalityCooldown.put(player,true);
            location = player.getEyeLocation();
            origin = location.clone();
            direction = location.getDirection();
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (j >= 8 * 20) {
                        vitalityCooldown.put(player, null);
                        player.sendMessage("§aCelestialVitality is now available.");
                        j = 0;
                        this.cancel();
                    }
                    j++;
                    if (origin.distance(location) <= 20) {
                        location.add(direction.multiply(1));
                        location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 8, 0.3F, 0.3F, 0.3F, 0.05F);
                        for (Entity entity : location.getWorld().getNearbyEntities(location, 1, 1, 1)) {
                            if (entity instanceof Player) {
                                if (entity != player) {
                                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 20 * 5, 1, false));
                                    if (entity instanceof Player) {
                                        Player forEntity = (Player) entity;
                                        int absorption = (int)player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()/15;
                                        if(absorption>1000){
                                            absorption=1000;
                                        }
                                        forEntity.setAbsorptionAmount(absorption);
                                        entity.sendMessage("§aYou were healed by " + player.getName() + '!');
                                    }
                                } else {
                                    int absorption = (int)player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()/15;
                                    if(absorption>1000){
                                        absorption=1000;
                                    }
                                    player.setAbsorptionAmount(absorption);
                                }
                            }
                        }
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);
        }else {
            player.sendMessage("§cCelestialVitality is on cooldown.");
        }
    }
}
