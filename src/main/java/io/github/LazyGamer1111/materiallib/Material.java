package io.github.LazyGamer1111.materiallib;

import io.github.LazyGamer1111.materiallib.types.blockTypes.FullBlock;
import io.github.LazyGamer1111.materiallib.types.blockTypes.MaterialBlock;
import io.github.LazyGamer1111.materiallib.types.blockTypes.OreBlock;
import io.github.LazyGamer1111.materiallib.types.itemTypes.IngotItem;
import io.github.LazyGamer1111.materiallib.types.itemTypes.MaterialItem;
import io.github.LazyGamer1111.materiallib.types.itemTypes.RawIngot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

import java.util.ArrayList;
import java.util.List;

public class Material {
    public final OreBlock oreDeepslate;
    public final OreBlock oreStone;
    public final RawIngot rawIngot;
    public final FullBlock fullBlock;
    public final IngotItem ingot;

    public final AbstractBlock.Settings blockSettings;
    public final Item.Settings itemSettings;
    public final String name;

    // ═══════════════════════════════ Smelt Properties ════════════════════════════════
    public final int cookTime;
    public final float smeltExp;

    // ═════════════════════════════════════ Vein ══════════════════════════════════════
    public final int veinSize;

    // ═════════════════════════════════════ Color ═════════════════════════════════════
    public final int hexColor;

    // Implements basic ore blocks, full blocks, raw ingot and ingots.
    public Material(AbstractBlock.Settings blockSettings, Item.Settings itemSettings, String name, int cookTime, float smeltExp, int hexColor, int veinSize) {
        this.fullBlock = new FullBlock(blockSettings, name);
        this.oreDeepslate = new OreBlock(blockSettings, name, OreBlock.BlockTypes.DEEPSLATE);
        this.oreStone = new OreBlock(blockSettings, name, OreBlock.BlockTypes.STONE);
        this.rawIngot = new RawIngot(itemSettings, name, "raw_ingot");
        this.ingot = new IngotItem(itemSettings, name, "ingot");
        this.name = name;

        this.blockSettings = blockSettings;
        this.itemSettings = itemSettings;

        this.smeltExp = smeltExp;
        this.cookTime = cookTime;

        this.hexColor = hexColor;

        this.veinSize = veinSize;
    }

    public void register(){
        this.fullBlock.register(itemSettings);
        this.oreDeepslate.register(itemSettings);
        this.oreStone.register(itemSettings);
        this.rawIngot.register();
        this.ingot.register();
    }

    public ArrayList<MaterialBlock> getBlocks(){
        ArrayList<MaterialBlock> blocks = new ArrayList<>();

        blocks.add(fullBlock);
        blocks.add(oreDeepslate);
        blocks.add(oreStone);

        return blocks;
    }

    public MaterialItem[] getItems(){
        return new MaterialItem[]{ingot, rawIngot};
    }

    public List<ItemConvertible> getSmeltable(){
        return List.of(oreStone, oreDeepslate, rawIngot);
    }

    public List<OreBlock> getOres(){
        return List.of(this.oreStone, this.oreDeepslate);
    }
}
