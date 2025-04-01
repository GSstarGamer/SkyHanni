package at.hannibal2.skyhanni.features.xtra

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.minecraft.KeyDownEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.ChatUtils
import at.hannibal2.skyhanni.utils.LocationUtils
import at.hannibal2.skyhanni.utils.compat.MinecraftCompat
import net.minecraft.client.Minecraft

@SkyHanniModule
object PitchYaw {
    private val config get() =  SkyHanniMod.feature.xtra.pitchYaw

    @HandleEvent()
    fun onKeyDown(event: KeyDownEvent) {
        if (Minecraft.getMinecraft().currentScreen != null) return
        if (!config.pitchYawSnap) return


        when (event.keyCode) {
            config.increaseYawBind -> {
                val (yaw, pitch) = current()
                set(yaw + config.yawIncrement, pitch)
                ChatUtils.chat("§aIncreased§e yaw $yaw -> ${yaw+config.yawIncrement}")
            }

            config.decreaseYawBind -> {
                val (yaw, pitch) = current()
                set(yaw - config.yawIncrement, pitch)
                ChatUtils.chat("§4Decreased§e yaw $yaw -> ${yaw-config.yawIncrement}")

            }


            config.increasePitchBind -> {
                val (yaw, pitch) = current()
                set(yaw, pitch + config.pitchIncrement)
                ChatUtils.chat("§aIncreased§e pitch $pitch -> ${pitch+config.pitchIncrement}")
            }

            config.decreasePitchBind -> {
                val (yaw, pitch) = current()
                set(yaw, pitch - config.pitchIncrement)
                ChatUtils.chat("§4Decreased§e pitch $pitch -> ${pitch-config.pitchIncrement}")
            }

            else -> return
        }
    }

    fun set(yaw: Float, pitch: Float) {
        val plr = Minecraft.getMinecraft().thePlayer
        plr.setPositionAndRotation(plr.posX, plr.posY, plr.posZ, yaw, pitch)
    }

    fun current(): Pair<Float, Float> {
        val player = MinecraftCompat.localPlayer
        val yaw = LocationUtils.calculatePlayerYaw()
        val pitch = player.rotationPitch
        return Pair(yaw, pitch)
    }
}
