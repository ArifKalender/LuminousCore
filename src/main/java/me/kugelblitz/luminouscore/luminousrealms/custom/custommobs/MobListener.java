package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs;

import me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.active.GazesTheWaves;
import me.kugelblitz.luminouscore.luminousrealms.util.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobListener implements Listener {
    Player player;

    @EventHandler
    public void onDeath(EntityDeathEvent event) {

        if (event.getEntity().getKiller() instanceof Player) {
            player = event.getEntity().getKiller();

            if (event.getEntity().getCustomName().contains("§4Serenity Divider")) {
                Bukkit.broadcastMessage("§4Voidripping Twilight Fire §cwas slain by §3" + player.getName());
                Sounds.bossSlain(player);
            }
        }
        if (event.getEntity().getCustomName() != null) {
            if (event.getEntity().getCustomName().equalsIgnoreCase("§2Ancient Earthling")) {

            }
        }


        //cleardrops
        event.getDrops().clear();
        event.setDroppedExp(0);
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (entity.getCustomName() != null) {
            if (entity.getCustomName().contains("§cAlive Structure")) {
                if (damager instanceof Player) {
                    player = (Player) damager;
                    if (player.getInventory() != null) {
                        if (player.getInventory().getItemInMainHand() != null) {
                            if (!(player.getInventory().getItemInMainHand().getType().toString().contains("PICKAXE"))) {
                                event.setCancelled(true);
                                entity.getWorld().playSound(entity.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.3f, 1
                                );
                                player.sendMessage("§cThis entity can only be damaged by using a pickaxe.");
                            }
                        }
                    }
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onRegularDamage(EntityDamageEvent event) {
        if (event.getEntity().getCustomName() != null) {
            if (event.getEntity().getCustomName().contains("§3Gazes the Waves")) {
                if (event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    event.setDamage(1000);
                }
            }

        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {
        Entity entity = event.getEntity();
        Entity target = event.getTarget();

        if (entity.getCustomName() != null) {
            if (entity.getCustomName().contains("§3Gazes the Waves")) {
                if (target instanceof Player) {
                    ((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, 30 * 20, 2));
                    target.getWorld().spawnParticle(Particle.SOUL, ((Player) target).getEyeLocation(), 30, 0.5, 0.5, 0.5, 0.05);

                }
            }
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Squid) {
            if (entity.getWorld().getGameTime() > 12750) {
                event.setCancelled(true);
                new GazesTheWaves(entity.getLocation());
            }
        }
    }
}

