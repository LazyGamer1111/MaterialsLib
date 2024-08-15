package io.github.LazyGamer1111.materiallib;

import io.github.LazyGamer1111.materiallib.types.itemTypes.MaterialItem;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class materialRegistry {
    private static final ArrayList<Material> materials = new ArrayList<>();
    private static final ArrayList<MaterialItem> items = new ArrayList<>();


    public static Material register(Material material) {
        materials.add(material);
        material.register();
        return material;
    }

    public static ArrayList<Material> getMaterials() {
        return materials;
    }
}
