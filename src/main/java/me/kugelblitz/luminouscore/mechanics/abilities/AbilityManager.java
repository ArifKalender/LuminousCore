package me.kugelblitz.luminouscore.mechanics.abilities;

import me.kugelblitz.luminouscore.mechanics.abilities.deltus.FieryAura;
import me.kugelblitz.luminouscore.mechanics.abilities.deltus.MysticalSeal;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.CelestialVitality;
import me.kugelblitz.luminouscore.mechanics.abilities.siderealist.MeteorCrash;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.SilentLament;
import me.kugelblitz.luminouscore.mechanics.abilities.witherweaver.WitheristIntoxication;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.SerenityUnifier;
import me.kugelblitz.luminouscore.mechanics.abilities.zodiac.ZenWhip;
import me.kugelblitz.luminouscore.ui.crystallexicon.RCrystalLexicon;
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
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class AbilityManager implements Listener {
    private final Plugin plugin;
    private final HashMap<Player, ArmorStand[]> playerArmorStands = new HashMap<>();

    public AbilityManager(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        Player player = event.getPlayer();
        Location location=player.getLocation().add(player.getLocation().getDirection().multiply(2));

        if (!playerArmorStands.containsKey(player)) {
            ArmorStand armorStand1 = spawnArmorStand(UtilizationMethods.getLeftSide(location,2), "§e§lUltimate");
            ArmorStand armorStand2 = spawnArmorStand(new Location(location.getWorld(),location.getX(),location.getY()+0.2,location.getZ()), "§eAbility");
            ArmorStand armorStand3 = spawnArmorStand(UtilizationMethods.getRightSide(location,2), "§eUtility");

            playerArmorStands.put(player, new ArmorStand[]{armorStand1, armorStand2, armorStand3});
        } else {
            ArmorStand[] armorStands = playerArmorStands.get(player);
            for (ArmorStand armorStand : armorStands) {
                armorStand.remove();
            }
            playerArmorStands.remove(player);

            Location eye = player.getEyeLocation();
            Vector direction = eye.getDirection();

            player.sendMessage("else ici");
            for (int i = 0; i < 5; i++) {
                player.sendMessage("for1");

                Location currentLocation = eye.clone().add(direction.multiply(i));
                for (Entity entity : currentLocation.getWorld().getNearbyEntities(currentLocation, 0.3, 0.3, 0.3)) {
                    player.sendMessage("for2");

                    if (entity instanceof ArmorStand && entity.getCustomName() != null) {
                        player.sendMessage("if");

                        ArmorStand armorStand = (ArmorStand) entity;
                        String customName = armorStand.getCustomName();

                        if (customName.equals("§eAbility")) {
                            player.sendMessage("name control ability");

                            handleAbilitySelection(player);
                        } else if (customName.equals("§e§lUltimate")) {
                            handleUltimateSelection(player);
                        } else if (customName.equals("§eUtility")) {
                            handleUtilitySelection(player);
                        }
                    }
                }
            }
        }
    }

    private ArmorStand spawnArmorStand(Location location, String customName) {
        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setCustomName(customName);
        armorStand.setCustomNameVisible(true);
        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.getEquipment().setChestplate(new ItemStack(Material.ENCHANTED_BOOK));
        return armorStand;
    }

    private void handleAbilitySelection(Player player) {
        String religion = PlayerStats.getStats().getString(player.getUniqueId() + ".Info.Religion", "");
        switch (religion) {
            case "deltus":
                new MysticalSeal(player);
                break;
            case "zodiac":
                new ZenWhip(player);
                break;
            case "siderealist":
                new CelestialVitality(player);
                break;
            case "witherweaver":
                new WitheristIntoxication(player);
                break;
            default:
                new RCrystalLexicon(player);
                break;
        }
    }

    private void handleUltimateSelection(Player player) {
        String religion = PlayerStats.getStats().getString(player.getUniqueId() + ".Info.Religion", "");
        switch (religion) {
            case "deltus":
                new FieryAura(player);
                break;
            case "zodiac":
                new SerenityUnifier(player);
                break;
            case "siderealist":
                new MeteorCrash(player);
                break;
            case "witherweaver":
                new SilentLament(player);
                break;
            default:
                new RCrystalLexicon(player);
                break;
        }
    }

    private void handleUtilitySelection(Player player) {
    }
}
