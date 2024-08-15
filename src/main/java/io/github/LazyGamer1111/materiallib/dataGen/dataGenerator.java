package io.github.LazyGamer1111.materiallib.dataGen;

import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.dataGen.worldgen.ModConfiguredFeatures;
import io.github.LazyGamer1111.materiallib.dataGen.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Nullable;

public class dataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(oreRecipeGen::new);
        pack.addProvider(genModels::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(LangProvider::new);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return Materiallib.MOD_ID;
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
    }
}
