package io.github.LazyGamer1111.materiallib.types.blockTypes;

import io.github.LazyGamer1111.materiallib.types.itemTypes.IngotItem;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

public class OreBlock extends MaterialBlock {
    public final BlockTypes blockType;

    public OreBlock(Settings settings, String name, BlockTypes blockType) {
        super(settings, name + blockType.toString() +"_ore", blockType.getID());

        this.blockType = blockType;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public enum BlockTypes{
        DEEPSLATE("_deepslate", "deepslate_ore"),
        STONE("", "stone_ore");

        private final String name;
        private final String id;

        private BlockTypes(String s, String id) {
            name = s;
            this.id = id;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because name.equals(null) returns false
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
        public String getID(){return this.id;}

    }
}
