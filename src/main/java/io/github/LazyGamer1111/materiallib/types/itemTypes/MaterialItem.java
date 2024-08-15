package io.github.LazyGamer1111.materiallib.types.itemTypes;

import io.github.LazyGamer1111.materiallib.Materiallib;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MaterialItem extends Item {
    public final String name;
    public final String parentModel;

    public Item returnedItem;

    public MaterialItem(FabricItem.Settings settings, String name, String parentModel) {
        super((Settings) settings);

        this.name = name;
        this.parentModel = parentModel;
    }

    public void register(){
        returnedItem = Registry.register(Registries.ITEM, Identifier.of(Materiallib.MOD_ID, name), this);
    }
}
