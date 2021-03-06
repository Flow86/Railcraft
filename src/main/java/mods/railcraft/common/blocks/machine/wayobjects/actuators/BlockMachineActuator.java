/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.blocks.machine.wayobjects.actuators;

import mods.railcraft.common.blocks.TileManager;
import mods.railcraft.common.blocks.machine.BlockMachine;
import mods.railcraft.common.blocks.machine.RailcraftBlockMetadata;
import mods.railcraft.common.blocks.machine.interfaces.ITileRotate;
import mods.railcraft.common.items.ItemCircuit;
import mods.railcraft.common.items.RailcraftItems;
import mods.railcraft.common.plugins.forge.CraftingPlugin;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by CovertJaguar on 9/8/2016 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
@RailcraftBlockMetadata(variant = ActuatorVariant.class)
public class BlockMachineActuator extends BlockMachine<ActuatorVariant> {
    public static final PropertyEnum<EnumFacing> FACING = PropertyEnum.create("facing", EnumFacing.class, EnumFacing.HORIZONTALS);

    public BlockMachineActuator() {
        super(false);
        setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) {
        return 8;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, getVariantProperty(), FACING);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        state = super.getActualState(state, worldIn, pos);
        state = state.withProperty(FACING, TileManager.forTile(this::getTileClass, state, worldIn, pos)
                .retrieve(ITileRotate.class, ITileRotate::getFacing).orElse(EnumFacing.NORTH));
        return state;
    }

    @Override
    public void defineRecipes() {
        // Define Switch Lever
        ActuatorVariant actuator = ActuatorVariant.LEVER;
        if (actuator.isAvailable()) {
            ItemStack stack = actuator.getItem();
            CraftingPlugin.addRecipe(stack,
                    "RBW",
                    "PLI",
                    'W', "dyeWhite",
                    'I', "ingotIron",
                    'L', Blocks.LEVER,
                    'P', Blocks.PISTON,
                    'B', "dyeBlack",
                    'R', "dyeRed");
            CraftingPlugin.addRecipe(stack,
                    "RBW",
                    "ILP",
                    'W', "dyeWhite",
                    'I', "ingotIron",
                    'L', Blocks.LEVER,
                    'P', Blocks.PISTON,
                    'B', "dyeBlack",
                    'R', "dyeRed");
        }

        // Define Switch Motor
        actuator = ActuatorVariant.MOTOR;
        if (actuator.isAvailable()) {
            ItemStack stack = actuator.getItem();
            CraftingPlugin.addRecipe(stack,
                    "RBW",
                    "PCI",
                    'W', "dyeWhite",
                    'I', "ingotIron",
                    'P', Blocks.PISTON,
                    'C', RailcraftItems.CIRCUIT.getRecipeObject(ItemCircuit.EnumCircuit.RECEIVER),
                    'B', "dyeBlack",
                    'R', "dyeRed");
            CraftingPlugin.addRecipe(stack,
                    "RBW",
                    "ICP",
                    'W', "dyeWhite",
                    'I', "ingotIron",
                    'P', Blocks.PISTON,
                    'C', RailcraftItems.CIRCUIT.getRecipeObject(ItemCircuit.EnumCircuit.RECEIVER),
                    'B', "dyeBlack",
                    'R', "dyeRed");
        }
    }
}
