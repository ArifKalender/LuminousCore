package me.kugelblitz.luminouscore.luminousrealms.util;

import org.bukkit.Location;
import org.bukkit.Particle;

public class TestShapes {

    public static void createCircle(Double radius, Location location) {
        float angleIncrement = 1.0f / 360.0f;

        for (int i = 0; i < 360; i++) {
            float angle = i * angleIncrement;
            Location circlePoint = location.clone(); // Create a copy of the original location

            // Calculate the new location for this point on the circle
            double x = radius * Math.cos(Math.toRadians(angle));
            double z = radius * Math.sin(Math.toRadians(angle));

            circlePoint.add(x, 0, z);

            for (int j = 0; j <= radius; j++) {
                // You can add your particle spawn logic here
                // Use 'circlePoint' to spawn particles
                circlePoint.getWorld().spawnParticle(Particle.TOTEM, circlePoint, 5, 0.01, 0.01, 0.01, 0.05);
            }
        }
    }


}
