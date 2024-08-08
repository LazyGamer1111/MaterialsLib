package io.github.LazyGamer1111.materiallib;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class materialRegistry {
    private final ArrayList<Material> materials = new ArrayList<>();

    public Material register(Material material) {
        materials.add(material);
        return material;
    }

    public void initMaterials(){
        for(Material material : materials){
            for(materialItem item : material.getItems()){
                Registry.register(Registries.ITEM, Identifier.of(Materiallib.MOD_ID, item.name.replace(" ", "_").toLowerCase()), item);
            }
            for(materialBlock block : material.getBlocks()){
                Registry.register(Registries.BLOCK, Identifier.of(Materiallib.MOD_ID, block.name.replace(" ", "_").toLowerCase()), block);
            }
        }
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }
}
