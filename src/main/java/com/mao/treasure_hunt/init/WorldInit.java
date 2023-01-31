package com.mao.treasure_hunt.init;

import com.mao.treasure_hunt.TreasureHunt;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.Arrays;

public class WorldInit {
    private static ConfiguredFeature<?, ?> SOFT_TUFF_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, BlockInit.SOFT_TUFF_BLOCK.getDefaultState(), 32));
    public static PlacedFeature SOFT_TUFF_ORE_PLACED_FEATURE = new PlacedFeature(RegistryEntry.of(SOFT_TUFF_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(2),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))
            )
    );

    public static void blockFeatureInit() {
        {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TreasureHunt.MODID, "overworld_soft_tuff"),SOFT_TUFF_ORE_CONFIGURED_FEATURE);
            Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TreasureHunt.MODID, "overworld_soft_tuff"),SOFT_TUFF_ORE_PLACED_FEATURE);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                    RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TreasureHunt.MODID, "overworld_soft_tuff")));
        }
    }
}
