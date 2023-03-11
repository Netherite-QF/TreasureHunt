package com.mao.treasure_hunt.init;

import com.mao.treasure_hunt.TreasureHunt;
import com.mao.treasure_hunt.common.item.Brush;
import com.mao.treasure_hunt.common.item.Chisel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit {
    public static final Brush BRUSH = new Brush();
    public static final Chisel CHISEL = new Chisel();
    
    public static void item(String id, Item item) {
        Registry.register(Registry.ITEM, TreasureHunt.asId(id), item);
    }

    public static void itemInit() {
        {
            item("brush", BRUSH);
            item("chisel", CHISEL);
        }
    }
}
