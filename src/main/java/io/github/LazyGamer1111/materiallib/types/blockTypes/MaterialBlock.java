package io.github.LazyGamer1111.materiallib.types.blockTypes;

import io.github.LazyGamer1111.materiallib.Materiallib;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MaterialBlock extends Block {
    public final String name;
    public final String parentModel;

    public MaterialBlock(Settings settings, String name, String parentModel) {
        super(settings);
        this.name = name;
        this.parentModel = parentModel;
    }

    public void register(Item.Settings itemSettings) {
        Registry.register(Registries.BLOCK, Identifier.of(Materiallib.MOD_ID, name), this);
        Registry.register(Registries.ITEM, Identifier.of(Materiallib.MOD_ID, name), new BlockItem(this, itemSettings));
    }
}
