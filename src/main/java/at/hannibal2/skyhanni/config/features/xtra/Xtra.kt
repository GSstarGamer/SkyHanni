package at.hannibal2.skyhanni.config.features.xtra

import at.hannibal2.skyhanni.config.FeatureToggle
import com.google.gson.annotations.Expose
import io.github.notenoughupdates.moulconfig.annotations.Accordion
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption

class Xtra {
//     @ConfigOption(name = "Current Version", desc = "This is the SkyHanni version you are currently running")
//     @ConfigVersionDisplay
//     @Transient
//     var currentVersion: Unit? = null

    @Expose
    @ConfigOption(
        name = "Anti seed break",
        desc = "Does not break pumpkin/melon stems",
    )
    @ConfigEditorBoolean
    @FeatureToggle
    var antiStemBreak: Boolean = true

    @Expose
    @ConfigOption(name = "Pitch / Yaw", desc = "")
    @Accordion
    var pitchYaw: pitchYawConfig = pitchYawConfig()

    @Expose
    @ConfigOption(name = "ESP", desc = "")
    @Accordion
    var esp: ESP = ESP()
//
//     @ConfigOption(name = "Auto Updates", desc = "Automatically download new version on each startup")
//     @Expose
//     @FeatureToggle
//     @ConfigEditorBoolean
//     var fullAutoUpdates: Boolean = false
//
//     @ConfigOption(name = "Update Stream", desc = "How frequently you want updates for SkyHanni")
//     @Expose
//     @ConfigEditorDropdown
//     var updateStream: Property<UpdateStream> = Property.of(UpdateStream.RELEASES)
//
//     @ConfigOption(name = "Used Software", desc = "Information about used software and licenses")
//     @Accordion
//     @Expose
//     var licenses: Licenses = Licenses()
//
//     enum class UpdateStream(private val label: String, val stream: String) {
//         NONE("None", "none"),
//         BETA("Beta", "pre"),
//         RELEASES("Full", "full");
//
//         override fun toString() = label
//     }
//
//     class Licenses {
//         @ConfigOption(name = "MoulConfig", desc = "MoulConfig is available under the LGPL 3.0 License or later version")
//         @ConfigEditorButton(buttonText = "Source")
//         var moulConfig: Runnable = Runnable { openBrowser("https://github.com/NotEnoughUpdates/MoulConfig") }
//
//         @ConfigOption(
//             name = "NotEnoughUpdates",
//             desc = "NotEnoughUpdates is available under the LGPL 3.0 License or later version"
//         )
//         @ConfigEditorButton(buttonText = "Source")
//         var notEnoughUpdates: Runnable =
//             Runnable { openBrowser("https://github.com/NotEnoughUpdates/NotEnoughUpdates") }
//
//         @ConfigOption(name = "Forge", desc = "Forge is available under the LGPL 3.0 license")
//         @ConfigEditorButton(buttonText = "Source")
//         var forge: Runnable = Runnable { openBrowser("https://github.com/MinecraftForge/MinecraftForge") }
//
//         @ConfigOption(name = "LibAutoUpdate", desc = "LibAutoUpdate is available under the BSD 2 Clause License")
//         @ConfigEditorButton(buttonText = "Source")
//         var libAutoUpdate: Runnable = Runnable { openBrowser("https://github.com/nea89o/libautoupdate") }
//
//         @ConfigOption(name = "Mixin", desc = "Mixin is available under the MIT License")
//         @ConfigEditorButton(buttonText = "Source")
//         var mixin: Runnable = Runnable { openBrowser("https://github.com/SpongePowered/Mixin/") }
//
//         @ConfigOption(name = "DiscordIPC", desc = "DiscordIPC is available under the Apache License 2.0")
//         @ConfigEditorButton(buttonText = "GitHub")
//         var discordRPC: Runnable = Runnable { openBrowser("https://github.com/jagrosh/DiscordIPC") }
//     }
}
