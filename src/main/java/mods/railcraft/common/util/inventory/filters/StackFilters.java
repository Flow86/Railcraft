/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.util.inventory.filters;

import mods.railcraft.common.plugins.forge.OreDictPlugin;
import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.inventory.wrappers.IInventoryObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by CovertJaguar on 3/31/2016 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public final class StackFilters {
    private StackFilters() {
    }

    /**
     * Matches against the provided ItemStack.
     */
    public static Predicate<ItemStack> of(@Nonnull final ItemStack stack) {
        return stack1 -> InvTools.isItemEqual(stack1, stack);
    }

    /**
     * Matches against the provided Item.
     */
    public static Predicate<ItemStack> of(@Nonnull final Class<? extends Item> itemClass) {
        return stack -> stack != null && stack.getItem() != null && itemClass.isAssignableFrom(stack.getItem().getClass());
    }

    /**
     * Matches against the provided ItemStacks.
     *
     * If no ItemStacks are provided to match against, it returns true.
     */
    public static Predicate<ItemStack> anyOf(@Nonnull final ItemStack... stacks) {
        return anyOf(Arrays.asList(stacks));
    }

    /**
     * Matches against the provided ItemStacks.
     *
     * If no ItemStacks are provided to match against, it returns true.
     */
    public static Predicate<ItemStack> anyOf(@Nonnull final List<ItemStack> stacks) {
        return stack -> stacks.isEmpty() || stacks.stream().allMatch(s -> s == null) || InvTools.isItemEqual(stack, stacks);
    }

    /**
     * Matches only if the given ItemStack does not match any of the provided ItemStacks.
     *
     * Returns false if the ItemStack being matched is null and true if the stacks to match against is empty/nulled.
     */
    public static Predicate<ItemStack> noneOf(@Nonnull final ItemStack... stacks) {
        return anyOf(Arrays.asList(stacks));
    }

    /**
     * Matches only if the given ItemStack does not match any of the provided ItemStacks.
     *
     * Returns false if the ItemStack being matched is null and true if the stacks to match against is empty/nulled.
     */
    public static Predicate<ItemStack> noneOf(@Nonnull final Collection<ItemStack> stacks) {
        return stack -> {
            if (stack == null)
                return false;
            for (ItemStack filter : stacks) {
                if (filter == null)
                    continue;
                if (InvTools.isItemEqual(stack, filter))
                    return false;
            }
            return true;
        };
    }

    /**
     * Matches if the given ItemStack is registered as a specific OreType in the Ore Dictionary.
     */
    public static Predicate<ItemStack> ofOreType(@Nonnull final String oreTag) {
        return stack -> OreDictPlugin.isOreType(oreTag, stack);
    }

    /**
     * Matches if the Inventory contains the given ItemStack.
     */
    public static Predicate<ItemStack> containedIn(@Nonnull final IInventoryObject inv) {
        return stack -> InvTools.containsItem(inv, stack);
    }
}
