package at.hannibal2.skyhanni.config.features.xtra;

import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;


public class ESP {
    @ConfigOption(name = "Ore XRAY", desc = "Highlights ores")
    @Expose
    @ConfigEditorBoolean
    public boolean blockESP = false;
}
