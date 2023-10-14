package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.active;


import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SentientCore {

    public SentientCore(Location location) {

        Zombie sentientCore = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE, false);
        sentientCore.setInvisible(true);
        sentientCore.getEquipment().setHelmet(new ItemStack(Material.END_PORTAL_FRAME, 1));
        sentientCore.setBaby(true);
        sentientCore.setAI(false);
        sentientCore.setCustomName("§cSentient Core");
        sentientCore.setRotation(90, 0);
        new BukkitRunnable() {

            @Override
            public void run() {
                sentientCore.getWorld().spawnParticle(Particle.END_ROD, location, 100, 8, 8, 8, 0);
                sentientCore.getWorld().spawnParticle(Particle.GLOW, location, 60, 0.25, 0.5, 0.25, 0);
                for (Entity entity : sentientCore.getLocation().getWorld().getNearbyEntities(location, 8, 2, 8)) {
                    if (entity instanceof Player) {
                        if (((Player) entity).getHealth() > ((Player) entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() * 0.35) {
                            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10, 24));
                        } else {
                            ((Player) entity).damage(5, sentientCore);
                            ((Player) entity).setNoDamageTicks(0);
                        }
                    }
                }
                if (sentientCore.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 5);
    }

}
