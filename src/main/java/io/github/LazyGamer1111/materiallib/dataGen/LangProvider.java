package io.github.LazyGamer1111.materiallib.dataGen;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import io.github.LazyGamer1111.materiallib.types.blockTypes.MaterialBlock;
import io.github.LazyGamer1111.materiallib.types.itemTypes.MaterialItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class LangProvider extends FabricLanguageProvider {
    protected LangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        for(Material material : materialRegistry.getMaterials()){
            for(MaterialItem item : material.getItems()) {
                translationBuilder.add(item, item.langName);
            }
            for(MaterialBlock block : material.getBlocks()) {
                translationBuilder.add(block, block.langName);
            }
        }
    }
}
