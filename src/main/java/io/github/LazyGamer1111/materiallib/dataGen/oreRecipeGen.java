package io.github.LazyGamer1111.materiallib.dataGen;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class oreRecipeGen extends FabricRecipeProvider {
    public oreRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        for(Material material : materialRegistry.getMaterials()){
            RecipeProvider.offerSmelting(exporter, material.getSmeltable(), RecipeCategory.BUILDING_BLOCKS, material.ingot, material.smeltExp, material.cookTime, Materiallib.MOD_ID + "_" + material.name);
        }
    }
}
