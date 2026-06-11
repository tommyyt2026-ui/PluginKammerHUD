package de.pluginkammer.pkhud;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class PKHudClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HudRenderCallback.EVENT.register(new HudRenderer());

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlaytimeManager.tick();
        });

        KeybindManager.register();

        System.out.println("Pluginkammer HUD geladen!");
    }
}
