package me.kugelblitz.luminouscore.statmanagement;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

//damage calculation: (maxHealth*0.87)+(attack_damage*1.766666)
/* Cancel event, then apply damage. This way you can prevent the particles from happening.
 * Though this will also cause the damager to be null, but future you will have to deal with that ¯\_(ツ)_/¯*/
//FUN FACT: CANCELLING THE EVENT THEN CHANGING THE EVENT DAMAGER TO DAMAGE SOURCE DOESN'T WORK. DON'T DO THAT
/* you can later add so the witherweavers deal more damage than usual. Like a 20% buff maybe, but to balance
 * other religions you need to buff them. Maybe increase their healing? IDK you can deal with that when you're
 * not lazy enough to do that.*/


public class CustomDamageManager implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (event.getEntity() instanceof LivingEntity) {
                Player player = (Player) event.getDamager();
                double originalDamage = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                double newDamage = (maxHealth * 0.87) + (originalDamage * 1.76);

                event.setCancelled(true);
                ((LivingEntity) event.getEntity()).damage(newDamage);

            }
        }
    }
}
