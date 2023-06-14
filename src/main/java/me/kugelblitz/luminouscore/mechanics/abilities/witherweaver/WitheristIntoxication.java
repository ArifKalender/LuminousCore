package me.kugelblitz.luminouscore.mechanics.abilities.witherweaver;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class WitheristIntoxication {
    public static HashMap<Player,Boolean> intoxCooldown = new HashMap<Player,Boolean>();
    private int cd =0;
    Location location;
    Location origin;
    Vector direction;

    public WitheristIntoxication(Player player) {
        if(intoxCooldown.get(player)==null) {
            intoxCooldown.put(player,true);
            location = player.getEyeLocation();
            origin = location.clone();
            direction = location.getDirection();
            new BukkitRunnable() {
                @Override
                public void run() {
                    cd++;

                    if(cd>=20*15){
                        cd=0;
                        intoxCooldown.put(player,null);
                        this.cancel();
                    }
                    if (cd <= 20) {
                        location.add(direction.multiply(1));
                        location.getWorld().spawnParticle(Particle.SOUL, location, 8, 0.3F, 0.3F, 0.3F, 0.05F);
                        for (Entity entity : location.getWorld().getNearbyEntities(location, 1, 1, 1)) {
                            if (entity instanceof LivingEntity) {
                                if (!(entity instanceof Player)) {
                                    if (entity != player) {
                                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 1, false));
                                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 15, false));
                                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 15, false));
                                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 5, 15, false));
                                        ((LivingEntity) entity).damage(player.getLevel() * 1000);
                                    }
                                }
                            }
                        }
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);
        }else {
            player.sendMessage("§cWitheristIntoxication is on cooldown.");
        }
    }

}
