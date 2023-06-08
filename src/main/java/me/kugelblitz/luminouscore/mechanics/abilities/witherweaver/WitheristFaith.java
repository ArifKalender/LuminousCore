package me.kugelblitz.luminouscore.mechanics.abilities.witherweaver;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class WitheristFaith {

    public WitheristFaith(Player player){
        new BukkitRunnable(){
            @Override
            public void run() {
                if(!player.isOnline()){
                    this.cancel();
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,65,1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,65,1));
            }
        }.runTaskTimer(LuminousCore.plugin,0,60);
    }

}

