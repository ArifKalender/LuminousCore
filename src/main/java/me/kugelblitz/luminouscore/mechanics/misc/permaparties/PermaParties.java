package me.kugelblitz.luminouscore.mechanics.misc.permaparties;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

//management
public class PermaParties implements Listener {

    private static HashMap<Player,Boolean> partyEnabled = new HashMap<Player,Boolean>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        String msg = event.getMessage();
        Player player=event.getPlayer();
        if(PartyFile.getStats().getString(player.getUniqueId().toString()+".PermaParties.Party") != null) {
            String party = PartyFile.getStats().getString(player.getUniqueId().toString() + ".PermaParties.Party");

            if (partyEnabled.get(player) == null) {
                return;
            } else {

            }
        }
    }


}
