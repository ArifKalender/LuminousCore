package me.kugelblitz.luminouscore.mechanics.abilities.siderealist;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class SpatialSoar {
    int i=0;
    public static HashMap<Player,Boolean> spatialCooldown = new HashMap<Player,Boolean>();
    public SpatialSoar(Player player){
        if(spatialCooldown.get(player)==null) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    spatialCooldown.put(player, true);

                    i++;
                    if (i < 20 * 3) {
                        player.setVelocity(player.getLocation().getDirection());
                        UtilizationMethods.playRegularSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,0,1);
                        player.getWorld().spawnParticle(Particle.SPELL_WITCH,player.getLocation(),15,1,0.2,1,0);
                    }
                    if (i >= 20 * 25) {
                        spatialCooldown.put(player,null);
                        player.sendMessage("§aSpatialSoar is now available.");
                        this.cancel();
                    }
                }
            }.runTaskTimer(LuminousCore.plugin, 0, 1);
        }else {
            player.sendMessage("§cSpatialSoar is currently on cooldown.");
        }
    }

}
