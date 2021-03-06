/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.items.enchantment;

import mods.railcraft.common.items.ItemCrowbar;
import mods.railcraft.common.items.ItemSpikeMaul;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class EnchantmentToolRailcraft extends Enchantment {

    public EnchantmentToolRailcraft(String tag, Rarity rarity, EntityEquipmentSlot... slots) {
        super(rarity, EnumEnchantmentType.DIGGER, slots);
        setName("railcraft." + tag);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof ItemCrowbar || stack.getItem() instanceof ItemSpikeMaul;
    }

}
