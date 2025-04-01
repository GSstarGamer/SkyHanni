package at.hannibal2.skyhanni.features.xtra

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.minecraft.packet.PacketSentEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.ChatUtils
import net.minecraft.network.play.client.C07PacketPlayerDigging
import net.minecraft.client.Minecraft


@SkyHanniModule
object AntiStemBreak {
    private val config get() =  SkyHanniMod.feature.xtra
    private val mc = Minecraft.getMinecraft()


    @HandleEvent
    fun onSeedBreak(event: PacketSentEvent) {
        if(!config.antiStemBreak) return
        val packet = event.packet

        if (packet is C07PacketPlayerDigging && packet.status == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) {
            val block = mc.theWorld.getBlockState(packet.position).block.localizedName
            if (!block.contains("stem", ignoreCase = true)) return

            val newPacket = C07PacketPlayerDigging(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, packet.position, packet.facing)
            mc.netHandler.addToSendQueue(newPacket)
            event.cancel()
            ChatUtils.chat("Stopped you from breaking a stem", prefixColor = "§8")
        }
    }
}
