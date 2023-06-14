package me.kugelblitz.luminouscore.mechanics.abilities;

import me.kugelblitz.luminouscore.mechanics.abilities.deltus.FieryAura;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.MysticalSeal;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.CelestialVitality;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.MeteorCrash;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.SilentLament;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristIntoxication;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.SerenityUnifier;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.ZenWhip;
import me.kugelblitz.luminouscore.util.PlayerStats;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class AbilityManager implements Listener {

    public static HashMap<Player,Boolean> abilityManager = new HashMap<Player,Boolean>();
    ArmorStand[] armorStands = new ArmorStand[3];
    ArmorStand a1;
    ArmorStand a2;
    ArmorStand a3;
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player=event.getPlayer();
        Location location=player.getLocation().add(player.getLocation().getDirection().multiply(2));
        Vector dir = location.getDirection();

        //open manager logic
        if(abilityManager.get(player)==null){
            abilityManager.put(player,true);
            a1 = (ArmorStand) location.getWorld().spawnEntity(UtilizationMethods.getLeftSide(location,1.7), EntityType.ARMOR_STAND);
            a2 = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            a3 = (ArmorStand) location.getWorld().spawnEntity(UtilizationMethods.getRightSide(location,1.7), EntityType.ARMOR_STAND);
            a1.setCustomName("§3Utility");
            a2.setCustomName("§eAbility");
            a3.setCustomName("§e§lUltimate");
                a1.setInvisible(true);
                a2.setInvisible(true);
                a3.setInvisible(true);
                a1.setGravity(false);
                a2.setGravity(false);
                a3.setGravity(false);
                a1.setCustomNameVisible(true);
                a2.setCustomNameVisible(true);
                a3.setCustomNameVisible(true);
                a1.getEquipment().setHelmet(new ItemStack(Material.WARPED_HYPHAE,1));
                a2.getEquipment().setHelmet(new ItemStack(Material.WARPED_HYPHAE,1));
                a3.getEquipment().setHelmet(new ItemStack(Material.WARPED_HYPHAE,1));


        }else {//use ability logic
            abilityManager.put(player,null);
            if(!a1.isDead()){
                a1.remove();
            }
            if(!a2.isDead()){
                a2.remove();
            }
            if(!a3.isDead()){
                a3.remove();
            }
        }

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){

        Entity entity=event.getEntity();
        if(event.getDamager() instanceof Player) {
            Player player=(Player)event.getDamager();
            //use ability logic
            abilityManager.put(player,true);
            if(!a1.isDead()){
                a1.remove();
            }
            if(!a2.isDead()){
                a2.remove();
            }
            if(!a3.isDead()){
                a3.remove();
            }

            String religion = PlayerStats.getStats().getString(player.getUniqueId()+".Info.Religion");
            if (entity.getCustomName().equals("§eAbility")) {
                event.setCancelled(true);
                if(religion.equals("deltus")){
                    new MysticalSeal(player);
                } else if (religion.equals("siderealist")) {
                    new CelestialVitality(player);
                } else if (religion.equals("witherweaver")) {
                    new WitheristIntoxication(player);
                } else if (religion.equals("zodiac")) {
                    new ZenWhip(player);
                }else{
                    player.sendMessage("§cYou haven't chosen a religion!");
                }
            } else if (entity.getCustomName().equals("§e§lUltimate")) {
                event.setCancelled(true);
                if(religion.equals("deltus")){
                    new FieryAura(player);
                } else if (religion.equals("siderealist")) {
                    new MeteorCrash(player);
                } else if (religion.equals("witherweaver")) {
                    new SilentLament(player);
                } else if (religion.equals("zodiac")) {
                    new SerenityUnifier(player);
                }else{
                    player.sendMessage("§cYou haven't chosen a religion!");
                }
                event.setCancelled(true);
            } else if (entity.getCustomName().equals("§3Utility")) {
                event.setCancelled(true);
            }

        }
    }
}
