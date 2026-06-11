package de.pluginkammer.pkhud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ServerInfo;

public class HudRenderer implements HudRenderCallback {

    private static final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {

        if (!KeybindManager.hudEnabled) {
            return;
        }

        if (client.player == null) {
            return;
        }

        int x = 5;
        int y = 5;

        String fps = "FPS: " + client.getCurrentFps();

        String xyz = String.format(
                "XYZ: %.0f %.0f %.0f",
                client.player.getX(),
                client.player.getY(),
                client.player.getZ()
        );

        String server = "Server: Singleplayer";

        ServerInfo serverInfo = client.getCurrentServerEntry();
        if (serverInfo != null) {
            server = "Server: " + serverInfo.address;
        }

        String ping = "Ping: ?";

        if (client.getNetworkHandler() != null) {
            var entry = client.getNetworkHandler()
                    .getPlayerListEntry(client.player.getUuid());

            if (entry != null) {
                ping = "Ping: " + entry.getLatency() + "ms";
            }
        }

        String playtime = "Playtime: " + PlaytimeManager.getPlaytime();

        drawContext.drawText(
                client.textRenderer,
                "===== Pluginkammer =====",
                x,
                y,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                fps,
                x,
                y + 12,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                xyz,
                x,
                y + 24,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                server,
                x,
                y + 36,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                ping,
                x,
                y + 48,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                playtime,
                x,
                y + 60,
                0xFFFFFF,
                true
        );

        drawContext.drawText(
                client.textRenderer,
                "=======================",
                x,
                y + 72,
                0xFFFFFF,
                true
        );
    }
}
