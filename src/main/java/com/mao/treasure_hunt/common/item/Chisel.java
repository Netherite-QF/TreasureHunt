package com.mao.treasure_hunt.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Chisel extends Item {
    public Chisel() {
        super(new Item.Settings().maxDamage(64).group(ItemGroup.TOOLS));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.IRON_INGOT);
    }
}
