package me.kugelblitz.luminouscore.mechanics.abilities.zodiac;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DoubleRegeneration {

    public DoubleRegeneration(Player player){
        new BukkitRunnable(){
            @Override
            public void run() {
                if(!player.isOnline()){
                    this.cancel();
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,64,0,false,false));
            }
        }.runTaskTimer(LuminousCore.plugin,0,60);
    }

}
