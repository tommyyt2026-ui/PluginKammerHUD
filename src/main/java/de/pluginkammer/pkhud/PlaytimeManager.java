package de.pluginkammer.pkhud;

public class PlaytimeManager {

    private static long joinTime = System.currentTimeMillis();

    public static String getPlaytime() {
        long seconds = (System.currentTimeMillis() - joinTime) / 1000;

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;

        return hours + "h " + minutes + "m";
    }

    public static void resetTimer() {
        joinTime = System.currentTimeMillis();
    }
}
