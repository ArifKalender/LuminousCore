package me.kugelblitz.luminouscore.mechanics.abilities.zodiac;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CelestialZap {
    int i=0;
    Location location;
    Vector direction;
    public CelestialZap(Player player){
        location=player.getEyeLocation();
        direction = location.getDirection();
        new BukkitRunnable(){
            @Override
            public void run() {
                if(i<=20){
                    i++;
                    if(location.getBlock().getType()!= Material.AIR){
                        location.add(direction.multiply(-1));
                        player.teleport(location);
                        this.cancel();
                    }else {
                        location = location.add(direction.multiply(1));
                    }
                    player.teleport(location);
                }else {
                    i=0;
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin,0,1);
    }

}
