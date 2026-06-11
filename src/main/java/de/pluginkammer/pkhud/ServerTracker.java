package de.pluginkammer.pkhud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public class ServerTracker {

    public static String getCurrentServer() {
        MinecraftClient client = MinecraftClient.getInstance();

        ServerInfo info = client.getCurrentServerEntry();

        if (info == null) {
            return "singleplayer";
        }

        return info.address;
    }
}
