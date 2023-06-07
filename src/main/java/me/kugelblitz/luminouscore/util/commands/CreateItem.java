package me.kugelblitz.luminouscore.util.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class CreateItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.isOp()) {
                if (args.length < 2) {
                    sender.sendMessage("§cIncomplete command. Syntax: /createitem [modifier] [modifierLevel]");
                } else {
                    if (args[0].equalsIgnoreCase("health")) {
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "healthModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                            itemStack.setItemMeta(meta);
                        }

                    } else if (args[0].equalsIgnoreCase("damage")) {
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "damageModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                            itemStack.setItemMeta(meta);
                        }
                    } else if (args[0].equalsIgnoreCase("kbres")) {
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        ItemMeta meta = itemStack.getItemMeta();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "kbResModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                            itemStack.setItemMeta(meta);
                        }
                    } else if (args[0].equalsIgnoreCase("knockback")) {
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "knockbackModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                            itemStack.setItemMeta(meta);
                        }

                    } else if (args[0].equalsIgnoreCase("speed")) {

                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "speedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        }
                    } else if (args[0].equalsIgnoreCase("attackspeed")) {

                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        String itemName = player.getInventory().getItemInMainHand().getType().toString();
                        if (itemName.contains("HELMET")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("CHESTPLATE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOOTS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("LEGGINGS")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("SWORD")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("BOW")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("HOE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        } else if (itemName.contains("AXE")) {
                            UUID uuid = UUID.randomUUID();
                            AttributeModifier modifier = new AttributeModifier(uuid, "attackSpeedModifier", Double.valueOf(args[1]), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                            itemStack.setItemMeta(meta);
                        }

                    } else if (args[0].equalsIgnoreCase("unbreakable")) {
                        ItemStack itemStack = player.getInventory().getItemInMainHand();
                        ItemMeta meta = itemStack.getItemMeta();
                        meta.setUnbreakable(true);
                        itemStack.setItemMeta(meta);
                    }
                }
            }
        } else {
            sender.sendMessage("§cYou need to be a player to execute this command.");
        }


        return false;
    }
}
