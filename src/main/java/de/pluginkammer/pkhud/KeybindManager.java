package de.pluginkammer.pkhud;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class KeybindManager {

    public static boolean hudEnabled = true;

    private static final KeyBinding TOGGLE_HUD = new KeyBinding(
            "key.pkhud.toggle",
            InputUtil.Type.KEYSYM,
            InputUtil.GLFW_KEY_RIGHT_SHIFT,
            "category.pkhud"
    );

    public static void register() {

        net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper.registerKeyBinding(TOGGLE_HUD);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TOGGLE_HUD.wasPressed()) {
                hudEnabled = !hudEnabled;
            }
        });
    }
}
