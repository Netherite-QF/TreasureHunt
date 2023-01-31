package com.mao.treasure_hunt.init;


import com.mao.treasure_hunt.TreasureHunt;
import com.mao.treasure_hunt.common.item.enchantment.ExorcismEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentInit {
    public static final Enchantment EXORCISM = new ExorcismEnchantment();

    public static void enchantmentInit() {
        {
            Registry.register(Registry.ENCHANTMENT,new Identifier(TreasureHunt.MODID, "exorcism"), EXORCISM);
        }
    }
}
