package me.kugelblitz.luminouscore.mechanics.currency;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class MaterialManager implements Listener {
    public static HashMap<Player,Integer> astralMemory = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> dResidue = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> wokeEcho = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> veilCatalyst = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> cGlyph = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> controlEssence = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> starLight = new HashMap<Player,Integer>();
    public static HashMap<Player,Integer> entropy = new HashMap<Player,Integer>();
    @EventHandler
    public void onPickUp(InventoryPickupItemEvent event){
        if(event.getInventory().getHolder() instanceof Player){
            Player player= (Player) event.getInventory().getHolder();
            ItemStack itemStack=event.getItem().getItemStack();
            if(itemStack.getItemMeta()!=null){
                if(itemStack.getItemMeta().getDisplayName()!=null){
                    if(itemStack.getItemMeta().getDisplayName().equals("§3Astral Memory")){
                        if(astralMemory.get(player)==null){
                            astralMemory.put(player,1);
                        }else if(astralMemory.get(player)<=24) {
                            astralMemory.put(player,astralMemory.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    } else if (itemStack.getItemMeta().getDisplayName().equals("§3Dimensional Residue")) {
                        if(dResidue.get(player)==null){
                            dResidue.put(player,1);
                        }else if(dResidue.get(player)<=24) {
                            dResidue.put(player,dResidue.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Woke Echo")) {
                        if(wokeEcho.get(player)==null){
                            wokeEcho.put(player,1);
                        }else if(wokeEcho.get(player)<=24) {
                            wokeEcho.put(player,wokeEcho.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Veil Catalyst")) {
                        if(veilCatalyst.get(player)==null){
                            veilCatalyst.put(player,1);
                        }else if(veilCatalyst.get(player)<=24) {
                            veilCatalyst.put(player,veilCatalyst.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Celestial Glyph")) {
                        if(cGlyph.get(player)==null){
                            cGlyph.put(player,1);
                        }else if(astralMemory.get(player)<=24) {
                            cGlyph.put(player,cGlyph.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Control Essence")) {
                        if(controlEssence.get(player)==null){
                            controlEssence.put(player,1);
                        }else if(controlEssence.get(player)<=24) {
                            controlEssence.put(player,controlEssence.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Starlight")) {
                        if(starLight.get(player)==null){
                            starLight.put(player,1);
                        }else if(starLight.get(player)<=24) {
                            starLight.put(player,starLight.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }else if (itemStack.getItemMeta().getDisplayName().equals("§3Entropy")) {
                        if(entropy.get(player)==null){
                            entropy.put(player,1);
                        }else if(entropy.get(player)<=24) {
                            entropy.put(player,entropy.get(player)+1);
                        }else {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }else{
            event.setCancelled(true);
        }
    }

}
