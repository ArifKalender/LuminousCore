package me.kugelblitz.luminouscore.custom.customitems.items;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class LuckyCharm implements Listener {

    public static void LuckyCharmRecipe() {
        NamespacedKey key = new NamespacedKey(LuminousCore.plugin, "LUCKY_CHARM");
        ItemStack luckycharm = new ItemStack(Material.LARGE_AMETHYST_BUD);
        ItemMeta luckycharmmeta = luckycharm.getItemMeta();
        luckycharmmeta.setDisplayName("§dLucky Charm");
        luckycharmmeta.setLore(Arrays.asList("", "§7Increases §2Luck §7when held", "§7in your inventory.", "", "§d§lREMARKABLE"));
        luckycharm.setItemMeta(luckycharmmeta);

        ItemStack luckshard = new ItemStack(Material.AMETHYST_SHARD, 1);
        ItemMeta luckmeta = luckshard.getItemMeta();
        luckmeta.setDisplayName("§3Shard of Luck");
        luckmeta.setLore(Arrays.asList("", "§7Used for crafting the renowned", "§dCharm of Luck§7 which increases", "§7the §2❀ Luck§7 stat of player.", "", "§d§lREMARKABLE"));
        luckshard.setItemMeta(luckmeta);

        ShapedRecipe recipe = new ShapedRecipe(key, luckycharm);
        RecipeChoice luckShardChoice = new RecipeChoice.ExactChoice(luckshard);
        recipe.shape("ABC", "DEF", "GHI");
        recipe.setIngredient('A', luckShardChoice);
        recipe.setIngredient('B', luckShardChoice);
        recipe.setIngredient('C', luckShardChoice);
        recipe.setIngredient('D', luckShardChoice);
        recipe.setIngredient('E', luckShardChoice);
        recipe.setIngredient('F', luckShardChoice);
        recipe.setIngredient('G', luckShardChoice);
        recipe.setIngredient('H', luckShardChoice);
        recipe.setIngredient('I', luckShardChoice);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        if (inventory != null) {
            for (ItemStack item : inventory.getContents()) {
                if (item.getItemMeta().getDisplayName() != null && item.getItemMeta().getDisplayName().equals("§dLucky Charm")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 15 * 20, 0, true));
                }
            }
        }
    }
}
