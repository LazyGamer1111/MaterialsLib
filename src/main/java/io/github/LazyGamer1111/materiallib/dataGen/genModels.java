package io.github.LazyGamer1111.materiallib.dataGen;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.Materiallib;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import io.github.LazyGamer1111.materiallib.types.blockTypes.MaterialBlock;
import io.github.LazyGamer1111.materiallib.types.itemTypes.MaterialItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class genModels extends FabricModelProvider {
    public genModels(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        for(Material material : materialRegistry.getMaterials()){
            for(MaterialBlock block : material.getBlocks()){
                generator.registerSingleton(
                        block,
                        TextureMap.texture(Blocks.STONE),
                        new Model(Optional.of(Identifier.of(Materiallib.MOD_ID, "abstract_block/" + block.parentModel)),
                                Optional.empty())
                );
            }
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        for(Material material : materialRegistry.getMaterials()){
            for(MaterialItem item : material.getItems()){
                generator.register(
                        item,
                        new Model(Optional.of(Identifier.of(Materiallib.MOD_ID, "abstract_item/" + item.parentModel)),
                                Optional.empty())
                );
            }
        }
    }
}
