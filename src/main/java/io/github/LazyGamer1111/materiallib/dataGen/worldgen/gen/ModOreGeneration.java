package io.github.LazyGamer1111.materiallib.dataGen.worldgen.gen;

import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.dataGen.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModOreGeneration {
    public static void generateOres() {
        ModPlacedFeatures.setPlacedFeaturesKeys();
        Materiallib.LOGGER.info("Generating Ores in Mod Ore Generation");
        for(RegistryKey<PlacedFeature> key : ModPlacedFeatures.placedFeaturesKeys) {
            Materiallib.LOGGER.info("Generating " + key.toString());
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, key);
        }
    }
}
