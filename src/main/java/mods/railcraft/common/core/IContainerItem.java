/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.core;

import net.minecraft.item.Item;

import javax.annotation.Nullable;

/**
 * Lets see if we can remove some boilerplate with this.
 * <p>
 * Created by CovertJaguar on 3/24/2016.
 */
public interface IContainerItem {
    @Nullable
    Item item();
}
