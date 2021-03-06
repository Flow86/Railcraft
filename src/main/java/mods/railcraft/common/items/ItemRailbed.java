/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.items;

import mods.railcraft.api.core.IRailcraftRecipeIngredient;
import mods.railcraft.api.core.IVariantEnum;
import mods.railcraft.common.items.ItemTie.EnumTie;
import mods.railcraft.common.plugins.forge.CraftingPlugin;
import mods.railcraft.common.plugins.forge.RailcraftRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Locale;

public class ItemRailbed extends ItemRailcraftSubtyped {

    public ItemRailbed() {
        super(EnumRailbed.class);
    }

    @Override
    public void initializeDefinintion() {
        for (EnumRailbed railbed : EnumRailbed.VALUES) {
            RailcraftRegistry.register(this, railbed, new ItemStack(this, 1, railbed.ordinal()));
        }
    }

    @Override
    public void defineRecipes() {
        RailcraftItems item = RailcraftItems.RAILBED;

        Object tieWood = RailcraftItems.TIE.getRecipeObject(EnumTie.WOOD);
        CraftingPlugin.addShapelessRecipe(item.getStack(1, EnumRailbed.WOOD),
                tieWood, tieWood, tieWood, tieWood);

        Object tieStone = RailcraftItems.TIE.getRecipeObject(EnumTie.STONE);
        CraftingPlugin.addShapelessRecipe(item.getStack(1, EnumRailbed.STONE),
                tieStone, tieStone, tieStone, tieStone);
    }

    public enum EnumRailbed implements IVariantEnum {
        WOOD("stickWood"),
        STONE(Blocks.STONE_SLAB);
        public static final EnumRailbed[] VALUES = values();
        private Object alternate;

        EnumRailbed(Object alt) {
            this.alternate = alt;
        }

        @Override
        public Object getAlternate(IRailcraftRecipeIngredient container) {
            return alternate;
        }

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

}
