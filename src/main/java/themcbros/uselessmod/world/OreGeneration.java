package themcbros.uselessmod.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import themcbros.uselessmod.UselessMod;
import themcbros.uselessmod.registry.ModBlocks;

public class OreGeneration {

    // Features
    private static final ConfiguredFeature<?, ?> ORE_USELESS = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.USELESS_ORE.getDefaultState(), 9)).rangeOf(64).spreadHorizontally().repeat(20);
    private static final ConfiguredFeature<?, ?> ORE_SUPER_USELESS = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.SUPER_USELESS_ORE.getDefaultState(), 9)).rangeOf(32).spreadHorizontally().repeat(2);

    public static void setupOreGeneration() {
        // Keys
        RegistryKey<ConfiguredFeature<?, ?>> oreUseless = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(UselessMod.MOD_ID, "ore_useless"));
        RegistryKey<ConfiguredFeature<?, ?>> oreSuperUseless = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(UselessMod.MOD_ID, "ore_super_useless"));
        // Register
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreUseless.getValue(), ORE_USELESS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSuperUseless.getValue(), ORE_SUPER_USELESS);
        // Add to biomes
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreUseless);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSuperUseless);
    }

}
