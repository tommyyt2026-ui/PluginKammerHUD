package de.pluginkammer.pkhud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public class ServerTracker {

    public static String getCurrentServer() {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.getCurrentServerEntry() != null) {
            ServerInfo info = client.getCurrentServerEntry();
            if (info.address != null && !info.address.isEmpty()) {
                return info.address;
            }
        }

        return "singleplayer";
    }
}
