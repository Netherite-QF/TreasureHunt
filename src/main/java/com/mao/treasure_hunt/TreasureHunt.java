package com.mao.treasure_hunt;

import com.mao.treasure_hunt.init.BlockInit;
import com.mao.treasure_hunt.init.EnchantmentInit;
import com.mao.treasure_hunt.init.ItemInit;
import com.mao.treasure_hunt.init.WorldInit;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreasureHunt implements ModInitializer {
    public static final String MODID = "treasure_hunt";
    public static final Logger LOGGER = LoggerFactory.getLogger(TreasureHunt.class);
    
    public static Identifier asId(String path) {
        return new Identifier(MODID, path);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Welcome to the world of treasures !");
        BlockInit.blockInit();
        BlockInit.blockItemInit();
        WorldInit.blockFeatureInit();
        EnchantmentInit.enchantmentInit();
        ItemInit.itemInit();
    }
}
