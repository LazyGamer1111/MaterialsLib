package io.github.LazyGamer1111.materiallib.client;

import io.github.LazyGamer1111.materiallib.Material;
import io.github.LazyGamer1111.materiallib.materialRegistry;
import io.github.LazyGamer1111.materiallib.types.blockTypes.MaterialBlock;
import io.github.LazyGamer1111.materiallib.types.blockTypes.OreBlock;
import io.github.LazyGamer1111.materiallib.types.itemTypes.MaterialItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorResolverRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.fabricmc.fabric.mixin.networking.client.accessor.MinecraftClientAccessor;
import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.ColorHelper;

public class MateriallibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static void lateInit(){
        for(Material material : materialRegistry.getMaterials()) {
            for(MaterialBlock block : material.getBlocks()){
                if(block instanceof OreBlock){
                    BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
                }
                ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> material.hexColor, block);
                ColorProviderRegistry.ITEM.register((stack, tintIndex) -> material.hexColor, block);
            }


            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0 ? ColorHelper.Argb.fullAlpha(material.hexColor) : -1, material.getItems());
        }
    }
}
