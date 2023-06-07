package me.kugelblitz.luminouscore.mechanics.mayorsystem.mayors;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.mechanics.mayorsystem.MayorHandler;
import me.kugelblitz.luminouscore.util.Sounds;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

//AATROX BENZERI, SLAYER YA DA MOB ÖLDÜRME ODAKLI
public class MoragMayorF implements Listener {
    int i = 0;

    public static void dropSmite(Entity victim, Player player) {

        ItemStack darbe = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta darbemeta = darbe.getItemMeta();
        darbemeta.setUnbreakable(true);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        darbemeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        darbemeta.setDisplayName("§b§lSmite");
        darbemeta.addEnchant(Enchantment.DURABILITY, 1, true);
        darbemeta.setLore(Arrays.asList("", "§3This axe has been casted", "§3with the souls of 1000 deads!", "", "§d§lREMARKABLE"));
        darbemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        darbe.setItemMeta(darbemeta);
        victim.getLocation().getWorld().dropItem(victim.getLocation(), darbe);
        Sounds.remarkableDrop(player);
    }

    public static void dropCorruptedHeart(Entity victim, Player player) {
        ItemStack yozlasmisKalp = new ItemStack(Material.CRIMSON_FUNGUS);
        ItemMeta yozlasmisKalpMeta = yozlasmisKalp.getItemMeta();
        yozlasmisKalpMeta.setDisplayName("§c§lCorrupted Heart");
        yozlasmisKalpMeta.setLore(Arrays.asList("", "§cThis heart heals you", "§Cfor 3 hearts.", "", "§6§lABILITY: §6Heal up §e§lRIGHT CLICK", "§7Heals you for §a2 hearts ❤ §7.", "", "§d§lREMARKABLE"));
        yozlasmisKalp.setItemMeta(yozlasmisKalpMeta);
        victim.getLocation().getWorld().dropItem(victim.getLocation(), yozlasmisKalp);
        Sounds.remarkableDrop(player);
    }

    public static void dropTotemOfJustice(Entity victim, Player player) {
        ItemStack adaletTotemi = new ItemStack(Material.RAW_GOLD);
        ItemMeta adaletTotemiMeta = adaletTotemi.getItemMeta();
        adaletTotemiMeta.setDisplayName("§6§lTotem of Justice");
        adaletTotemiMeta.setLore(Arrays.asList("", "§eThis totem grants invulnerability", "§eagainst projectiles.", "", "§4§LEXOTIC"));
        adaletTotemi.setItemMeta(adaletTotemiMeta);
        victim.getWorld().dropItem(victim.getLocation(), adaletTotemi);
        Sounds.exoticDrop(player);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (MayorHandler.mayor.equals("morag")) {
            Entity damager = event.getEntity().getKiller();
            Entity victim = event.getEntity();


            if (damager instanceof Player) {

                if (victim.getCustomName() != null && victim.getCustomName().contains("§cKasvetli Ceset")) {
                    Random random = new Random();
                    double randomnumber = random.nextDouble();
                    if (randomnumber <= 0.005) { // 200de 1
                        dropSmite(victim, (Player) damager);
                    }
                } else if (victim.getCustomName() != null && victim.getCustomName().contains("§cYozlaşmış İblis")) {
                    Random random = new Random();
                    double randomnumber = random.nextDouble();
                    if (randomnumber <= 0.003) { //333te 1
                        dropCorruptedHeart(victim, (Player) damager);
                    }
                } else if (victim.getCustomName() != null && victim.getCustomName().contains("§cKaçınılmaz Lanet")) {
                    Random random = new Random();
                    double randomnumber = random.nextDouble();
                    if (randomnumber < 0.001) { //1000de 1
                        dropTotemOfJustice(victim, (Player) damager);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (MayorHandler.mayor.equals("morag")) {
            Entity entity = event.getEntity();
            if (entity.getCustomName() != null) {
                if (entity.getCustomName().contains("§4§l[BOSS]")) {
                    Random random = new Random();
                    double number = random.nextDouble();
                    if (number < 0.1) {
                        if (event.getDamager() instanceof Player) {
                            event.getDamager().sendMessage("§aThe boss has been slowed for " + (int) (number * 140) + " seconds!");
                            LivingEntity lentity = (LivingEntity) entity;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    i++;
                                    lentity.teleport(lentity);

                                    if (i >= number * 140 * 20) {
                                        i = 0;
                                        event.getDamager().sendMessage("§c§lBEWARE §r§cThe boss is no longer stunned!");
                                        this.cancel();
                                    }
                                }
                            }.runTaskTimer(LuminousCore.plugin, 0, 1);
                        }
                    }
                    event.setDamage(event.getDamage() * 2);
                }
            }
        }
    }
}