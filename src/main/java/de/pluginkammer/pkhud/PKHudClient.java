package de.pluginkammer.pkhud;

import net.fabricmc.api.ClientModInitializer;

public class PKHudClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("Pluginkammer HUD geladen!");
    }
}
