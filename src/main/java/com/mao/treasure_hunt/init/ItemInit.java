package com.mao.treasure_hunt.init;

import com.mao.treasure_hunt.TreasureHunt;
import com.mao.treasure_hunt.common.item.Brush;
import com.mao.treasure_hunt.common.item.Chisel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit {
    public static final Brush BRUSH = new Brush(new Item.Settings().maxDamage(25).group(ItemGroup.TOOLS));
    public static final Chisel CHISEL = new Chisel(new Item.Settings().maxDamage(64).group(ItemGroup.TOOLS));

    public static void itemInit() {
        {
            Registry.register(Registry.ITEM,new Identifier(TreasureHunt.MODID,"brush"),BRUSH);
            Registry.register(Registry.ITEM,new Identifier(TreasureHunt.MODID,"chisel"),CHISEL);
        }
    }
}
