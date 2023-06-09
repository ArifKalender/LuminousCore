package me.kugelblitz.luminouscore.mechanics.abilities.deltus;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DeltusBeliever {

    public DeltusBeliever(Player player){
        new BukkitRunnable(){
            @Override
            public void run() {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,65,2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,65,0));
                if(!player.isOnline()){
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin,0,60);
    }

}
