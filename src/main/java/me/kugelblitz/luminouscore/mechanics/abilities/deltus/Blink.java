package me.kugelblitz.luminouscore.mechanics.abilities.deltus;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Blink {

    int i=0;
    public Blink(Player player){

        new BukkitRunnable(){
            @Override
            public void run() {
                if(i<1){
                    i++;
                    Location location = player.getEyeLocation();
                    Vector direction = location.getDirection();

                    for (int i = 0; i <= 20; i++) {
                        location.add(direction);

                        if (location.getBlock().getType() == Material.AIR || location.getBlock().getType() == Material.WATER) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,25,1));
                            location.getWorld().spawnParticle(Particle.WATER_SPLASH, location, 5, 0.2, 0.2, 0.2, 0.05);
                        } else {
                            location.add(direction.multiply(-1));
                            break;
                        }
                    }

                    player.teleport(location);
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 4, 0f);
                }else {
                    i=0;
                    player.setVelocity(player.getLocation().getDirection().multiply(1));
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin,0,1);



    }

}
