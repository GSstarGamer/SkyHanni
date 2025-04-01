package at.hannibal2.skyhanni.config.features.xtra;

import at.hannibal2.skyhanni.config.FeatureToggle;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorKeybind;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorSlider;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;
import org.lwjgl.input.Keyboard;


public class pitchYawConfig {
    @ConfigOption(name = "Look at command", desc = "use /lookat <yaw> <pitch>")
    @Expose
    @ConfigEditorBoolean
    public boolean lookAtToggle = true;


    @ConfigOption(name = "Pitch / Yaw set", desc = "Move your pitch or yaw with bind by X increments")
    @Expose
    @ConfigEditorBoolean
    public boolean pitchYawSnap = true;

    @Expose
    @ConfigOption(name = "Pitch increment", desc = "Pitch increment up to specified decimal.")
    @ConfigEditorSlider(
        minValue = 0.1f,
        maxValue = 10f,
        minStep = 0.1f
    )
    public float pitchIncrement = 5;

    @Expose
    @ConfigOption(name = "Yaw increment", desc = "Yaw increment up to specified decimal.")
    @ConfigEditorSlider(
        minValue = 0.1f,
        maxValue = 10f,
        minStep = 0.1f
    )
    public float yawIncrement = 5;

    @Expose
    @ConfigOption(name = "Increase pitch", desc = "Keybind to ADD specified pitch")
    @ConfigEditorKeybind(defaultKey = Keyboard.KEY_DOWN)
    public int increasePitchBind= Keyboard.KEY_DOWN;

    @Expose
    @ConfigOption(name = "Decrease pitch", desc = "Keybind to MINUS specified pitch")
    @ConfigEditorKeybind(defaultKey = Keyboard.KEY_UP)
    public int decreasePitchBind = Keyboard.KEY_UP;

    @Expose
    @ConfigOption(name = "Increase yaw", desc = "Keybind to ADD specified yaw")
    @ConfigEditorKeybind(defaultKey = Keyboard.KEY_RIGHT)
    public int increaseYawBind = Keyboard.KEY_RIGHT;

    @Expose
    @ConfigOption(name = "Decrease yaw", desc = "Keybind to MINUS specified yaw")
    @ConfigEditorKeybind(defaultKey = Keyboard.KEY_LEFT)
    public int decreaseYawBind = Keyboard.KEY_LEFT;
}
