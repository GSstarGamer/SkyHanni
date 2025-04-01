package at.hannibal2.skyhanni.features.xtra

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.MessageSendToServerEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.ChatUtils

@SkyHanniModule
object LookAt {

    private val config get() =  SkyHanniMod.feature.xtra.pitchYaw

    @HandleEvent
    fun onMessageSendToServer(event: MessageSendToServerEvent) {
        val message = event.message
        if (message.startsWith("/lookat")) {
            event.cancel()
            if (config.lookAtToggle) {
                val (yaw, pitch) = parseMessageToAngle(message)
                if (yaw == null || pitch == null) {
                    ChatUtils.userError("Invalid yaw or pitch.")
                } else {
                    PitchYaw.set(yaw, pitch)
                    ChatUtils.chat("§aSet yaw to §e$yaw§e and pitch to §e$pitch§e")
                }
            } else {
                ChatUtils.userError("Must be enabled in the Xtra settings")
            }

        }
    }

    private fun parseMessageToAngle(message: String): Pair<Float?, Float?> {
        val stringList = message.replace("/lookat ", "").split(" ")
        return Pair(stringList.getOrNull(0)?.toFloatOrNull(), stringList.getOrNull(1)?.toFloatOrNull())
    }
}
