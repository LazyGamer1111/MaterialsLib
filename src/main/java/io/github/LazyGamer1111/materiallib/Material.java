package io.github.LazyGamer1111.materiallib;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class Material {
    private final ArrayList<materialBlock> blocks = new ArrayList<>();
    private final ArrayList<materialItem> items =  new ArrayList<>();

    public Material(AbstractBlock.Settings blockSettings, Item.Settings itemSettings, String name) {
        this.blocks.add(new materialBlock(blockSettings, name + " ore"));
        this.blocks.add(new materialBlock(blockSettings, name + " block"));
        this.items.add(new materialItem(itemSettings, name + " ingot"));
        this.items.add(new materialItem(itemSettings, name + " dust"));
        this.items.add(new materialItem(itemSettings, name + " small dust"));
    }

    public ArrayList<materialBlock> getBlocks() {
        return blocks;
    }

    public ArrayList<materialItem> getItems() {
        return items;
    }
}
