package io.github.LazyGamer1111.materiallib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

public class Materiallib implements ModInitializer {
    public static final String MOD_ID = "materiallib";

    @Override
    public void onInitialize() {
        new Material(AbstractBlock.Settings.copy(Blocks.STONE), new Item.Settings() , "hi");
    }
}
