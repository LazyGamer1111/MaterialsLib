package io.github.LazyGamer1111.materiallib;

import io.github.LazyGamer1111.materiallib.dataGen.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class Materiallib implements ModInitializer {
    public static final String MOD_ID = "materiallib";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
    }

    public static void lateInit(){
        ModWorldGeneration.generateModWorldGen();
    }
}
