package me.kugelblitz.luminouscore.mechanics.abilities.witherweaver;

import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class HighLeap {

    public HighLeap(Player player){

        if(!player.isSneaking()){
            player.setVelocity(player.getLocation().getDirection().multiply(2.5));
        }else {
            player.setVelocity(player.getLocation().getDirection().multiply(-2.5));
        }
        UtilizationMethods.playRegularSound(player.getLocation(), Sound.ENTITY_HORSE_BREATHE,1,5);
        player.getWorld().spawnParticle(Particle.CLOUD,new Location(player.getWorld(),player.getLocation().getX(),player.getLocation().getY()+0.1,player.getLocation().getZ()),25,1,0.2,1,0);
    }

}
