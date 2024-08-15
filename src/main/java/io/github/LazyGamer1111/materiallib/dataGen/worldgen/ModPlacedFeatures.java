package io.github.LazyGamer1111.materiallib.dataGen.worldgen;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import io.github.LazyGamer1111.materiallib.types.blockTypes.OreBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

public class ModPlacedFeatures {
    public static List<RegistryKey<PlacedFeature>> placedFeaturesKeys = new ArrayList<>();
    private static List<Integer> counts = new ArrayList<>();

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        setPlacedFeaturesKeys();

        int numLoop = 0;
        for (RegistryKey<ConfiguredFeature<?, ?>> key : ModConfiguredFeatures.keys) {
            register(context, placedFeaturesKeys.get(numLoop), configuredFeatureRegistryEntryLookup.getOrThrow(key),
                    ModOrePlacement.modifiersWithCount(counts.get(numLoop), // Veins per Chunk
                            HeightRangePlacementModifier.uniform(YOffset.fixed(-30), YOffset.fixed(80))));
            numLoop++;
        }
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Materiallib.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void setPlacedFeaturesKeys(){
        for(Material material : materialRegistry.getMaterials()){
            placedFeaturesKeys.add(registerKey(material.name));
            counts.add(material.veinSize);
        }
    }
}
