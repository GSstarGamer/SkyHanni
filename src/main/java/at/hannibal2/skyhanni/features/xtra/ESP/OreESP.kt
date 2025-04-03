package at.hannibal2.skyhanni.features.xtra.ESP

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.ServerBlockChangeEvent
import at.hannibal2.skyhanni.events.minecraft.SkyHanniRenderWorldEvent
import at.hannibal2.skyhanni.events.minecraft.WorldChangeEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.LorenzColor
import at.hannibal2.skyhanni.utils.RenderUtils.drawWaypointFilled
import at.hannibal2.skyhanni.utils.toLorenzVec
import net.minecraft.client.Minecraft
import net.minecraftforge.event.world.ChunkEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraft.util.BlockPos
import net.minecraft.block.BlockStone
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.world.chunk.Chunk

@SkyHanniModule
object OreESP {
    private val mc = Minecraft.getMinecraft()
    private val oresMap = mutableMapOf<BlockPos, String>()
    private val config get() =  SkyHanniMod.feature.xtra.esp

    @HandleEvent
    fun onWorldChange(event: WorldChangeEvent) {
        oresMap.clear()
    }

    @SubscribeEvent
    fun onChunkLoad(event: ChunkEvent.Load) {
        val chunk: Chunk = event.chunk
        for (x in 0 until 16) {
            for (y in 0 until 256) { // 256 is the height limit in 1.8.9
                for (z in 0 until 16) {
                    val pos = BlockPos(chunk.xPosition * 16 + x, y, chunk.zPosition * 16 + z)
                    val block = chunk.getBlock(pos)

                    val (isOre, oreName) = isWantedOre(block.defaultState, pos)
                    if (isOre) {
                        oresMap[pos] = oreName
//                         ChatUtils.chat("[Chunk Load] Found ${oreName}, Pos: ${pos}}")
                    }
                }
            }
        }
    }

    @HandleEvent
    fun onBlockUpdate(event: ServerBlockChangeEvent ) {
        val state: IBlockState = event.newState
        val pos: BlockPos = event.location.toBlockPos()

        val (isOre, oreName) = isWantedOre(state, pos)
        if (isOre) {
            oresMap[pos] = oreName
//             ChatUtils.chat("[Chunk] Found ${oreName}, Pos: ${pos}}")
        }


        val oldState: IBlockState = event.oldState

        val (isOldOre, OldoreName) = isWantedOre(oldState, pos)
        if (isOldOre) {
                oresMap.remove(pos)
        }
    }

    @HandleEvent
    fun onRenderWorld(event: SkyHanniRenderWorldEvent) {
        if (!config.blockESP) return
        for ((pos, name) in oresMap) {
            event.drawWaypointFilled(pos.toLorenzVec(), LorenzColor.DARK_PURPLE.toColor(), seeThroughBlocks = true)
        }
    }



    fun isWantedOre(blockState: IBlockState, pos: BlockPos): Pair<Boolean, String> {
        if (blockState.block == Blocks.stone && blockState.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE_SMOOTH) {
                return Pair(true, "Titanium")
        }

//         return
        return Pair(false, "")
    }
}
