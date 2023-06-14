package me.kugelblitz.luminouscore.mechanics.abilities.siderealist;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class MeteorCrash {

    public static HashMap<Player, Boolean> meteorCd = new HashMap<Player, Boolean>();
    int j = 0;
    Location location;


    public MeteorCrash(Player player) {
        if (meteorCd.get(player) == null) {
            location = player.getEyeLocation();
            for (int i = 0; i <= 15; i++) {
                meteorCd.put(player, true);
                location.add(location.getDirection());
                location.getWorld().spawnParticle(Particle.FLAME, location, 1, 0, 0, 0, 0);
                if (i == 15) {
                    Location explosionLocation = new Location(location.getWorld(), location.getX(), location.getY() + 20, location.getZ());
                    ArmorStand meteor = (ArmorStand) explosionLocation.getWorld().spawnEntity(explosionLocation, EntityType.ARMOR_STAND, false);
                    meteor.setInvisible(true);
                    meteor.getEquipment().setHelmet(new ItemStack(Material.MAGMA_BLOCK, 1));
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if(!meteor.isDead()) {
                                meteor.getWorld().spawnParticle(Particle.FLAME, meteor.getLocation(), 15, 1f, 1f, 1f, 0.05f);
                            }
                            j++;
                            if (j >= 30 * 20) {
                                j = 0;
                                meteorCd.put(player,null);
                                player.sendMessage("§aMeteorCrash is now available.");
                                meteor.remove();
                                this.cancel();
                            }
                            if (meteor.isOnGround()) {
                                if(!meteor.isDead()) {
                                    meteor.getWorld().createExplosion(meteor.getLocation(), 4f, false);
                                    for(Entity entity:meteor.getNearbyEntities(5,5,5)){
                                        if(entity instanceof LivingEntity){
                                            if(!(entity instanceof Player)){
                                                ((LivingEntity) entity).damage(player.getLevel()*1000);
                                            }
                                        }
                                    }
                                    meteor.remove();
                                    j = 0;
                                }
                            }
                        }
                    }.runTaskTimer(LuminousCore.plugin, 0, 1);
                }
            }
        } else {
            player.sendMessage("§cMeteorCrash is currently on cooldown.");
        }

    }







    /*public MeteorCrash(Player player){
        player.sendMessage("meteorcrash");

        if(meteorCd.get(player) == null) {
            player.sendMessage("meteorCd null");
            meteorCd.put(player, true);
            location = player.getLocation();

            for (int j = 0; j <= 20; j++) {
                location.add(location.getDirection());
                for (Entity entity : location.getWorld().getNearbyEntities(location, 3, 3, 3)) {
                    if (entity instanceof LivingEntity) {
                        if (entity != player) {
                            if(meteorCd.get(player) == null) {
                                player.sendMessage("detected entity");
                                Location meteorLoc = new Location(location.getWorld(), location.getX(), location.getY() + 20, location.getZ());
                                spawnMeteor(player, meteorLoc);
                            }
                        }
                    }
                }
            }

        }else {
            player.sendMessage("§cMeteorCrash is on cooldown!");
        }
    }

    public void spawnMeteor(Player player, Location meteorLoc){
        if(meteorCd.get(player) == null) {
            meteor = (ArmorStand) meteorLoc.getWorld().spawnEntity(meteorLoc, EntityType.ARMOR_STAND, false);
            meteor.setInvisible(true);
            meteor.getEquipment().setHelmet(new ItemStack(Material.OBSIDIAN, 1));
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                player.sendMessage("runnable");
                if(meteor!=null) {
                    i++;
                    meteor.getWorld().spawnParticle(Particle.FLAME, meteor.getLocation(), 15, 1, 1, 1, 0.05);
                    if (meteor.isOnGround()) {
                        meteor.getWorld().spawnEntity(meteor.getLocation(), EntityType.PRIMED_TNT, false);
                        meteor.remove();
                        this.cancel();
                    }
                    if (i >= 120 * 20) {

                        meteorCd.put(player, null);
                    }
                }else {
                    player.sendMessage("meteor null nie öle aq");
                    meteorCd.put(player,null);
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin,10,1);
    }*/


}
