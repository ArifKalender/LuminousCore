package me.kugelblitz.luminouscore.PowerSurge;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Locale;
import java.util.Random;

public class ArenaGeyser {

    public ArenaGeyser(){
        World world = Bukkit.getWorld("powersurge".toLowerCase(Locale.ROOT));

        Location location=new Location(world,0,0,0);
        Vector direction = location.getDirection();

        int radiusInt = (int) Math.ceil(120); // Convert the radius to an integer

        new BukkitRunnable(){
            @Override
            public void run() {
                for (int x = -radiusInt; x <= radiusInt; x++) {
                    for (int y = -radiusInt; y <= radiusInt; y++) {
                        for (int z = -radiusInt; z <= radiusInt; z++) {
                            Location blockLocation = location.clone().add(x, y, z);
                            Block block = world.getBlockAt(blockLocation);

                            if (block.getType() == Material.MAGMA_BLOCK) {
                                Random random2=new Random();
                                double chance = random2.nextDouble();
                                if(chance>=0.8){
                                    createFirePillar(block);
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(LuminousCore.plugin,10*20,20);

    }

    public void createFirePillar(Block block){
        Location location=block.getLocation();
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+1,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+2,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+3,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+4,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+5,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);
        location.add(0,location.getY()+6,0);
        location.getWorld().spawnParticle(Particle.FLAME,location,10,1,1,1,0.05);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,location,10,1,1,1,0.05);

        for(Entity entity : location.getWorld().getNearbyEntities(location,1,7,1)){

            if(entity instanceof LivingEntity){
                ((LivingEntity) entity).damage(((LivingEntity) entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()*0.1);
            }

        }
    }

}
