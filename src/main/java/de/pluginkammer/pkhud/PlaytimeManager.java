package de.pluginkammer.pkhud;

import java.util.HashMap;
import java.util.Map;

public class PlaytimeManager {

    private static final Map<String, Long> playtimes = new HashMap<>();
    private static long lastUpdate = System.currentTimeMillis();

    public static void tick() {
        String server = ServerTracker.getCurrentServer();

        long now = System.currentTimeMillis();
        long diff = (now - lastUpdate) / 1000;

        if (diff > 0) {
            playtimes.put(
                    server,
                    playtimes.getOrDefault(server, 0L) + diff
            );

            lastUpdate = now;
        }
    }

    public static String getPlaytime() {
        String server = ServerTracker.getCurrentServer();

        long seconds = playtimes.getOrDefault(server, 0L);

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;

        return hours + "h " + minutes + "m";
    }
}
