/* 
 * Copyright (c) CovertJaguar, 2014 http://railcraft.info
 * 
 * This code is the property of CovertJaguar
 * and may only be used with explicit written
 * permission unless otherwise specified on the
 * license page at http://railcraft.info/wiki/info:license.
 */
package mods.railcraft.common.plugins.forge;

import mods.railcraft.common.blocks.IBlockContainer;
import mods.railcraft.common.blocks.IStateContainer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class HarvestPlugin {

    public static void setToolClass(Item item, String toolClass, int level) {
        item.setHarvestLevel(toolClass, level);
    }

    public static void setBlockHarvestLevel(String toolClass, int level, IBlockContainer blockContainer) {
        Block block = blockContainer.getBlock();
        if (block != null)
            setBlockHarvestLevel(toolClass, level, block);
    }

    public static void setBlockHarvestLevel(String toolClass, int level, Block block) {
        block.setHarvestLevel(toolClass, level);
    }

    public static void setStateHarvestLevel(String toolClass, int level, IStateContainer stateContainer) {
        IBlockState state = stateContainer.getState();
        if (state != null)
            setStateHarvestLevel(toolClass, level, state);
    }

    public static void setStateHarvestLevel(String toolClass, int level, IBlockState blockState) {
        blockState.getBlock().setHarvestLevel(toolClass, level, blockState);
    }

    public static int getHarvestLevel(Block block, IBlockState blockState, String toolClass) {
//        return block.getHarvestLevel(blockState, toolClass);
        return 0;
    }
}
