package me.kugelblitz.luminouscore.mechanics.abilities.siderealist;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SideRealistFaith {

    public SideRealistFaith(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) {
                    this.cancel();
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 65, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 65, 1));
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 60);
    }

}
