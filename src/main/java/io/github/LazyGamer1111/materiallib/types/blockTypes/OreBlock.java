package io.github.LazyGamer1111.materiallib.types.blockTypes;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

public class OreBlock extends MaterialBlock {
    public final BlockTypes blockType;

    public OreBlock(Settings settings, String name, String langName, BlockTypes blockType) {
        super(settings, name + blockType.toString() +"_ore", blockType.getLangName() + " " + langName + " ore", blockType.getID());

        this.blockType = blockType;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public enum BlockTypes{
        DEEPSLATE("_deepslate", "Deepslate", "deepslate_ore"),
        STONE("", "", "stone_ore");

        private final String name;
        private final String langName;
        private final String id;

        private BlockTypes(String s, String langName, String id) {
            name = s;
            this.langName = langName;
            this.id = id;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because name.equals(null) returns false
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
        public String getLangName() {return this.langName;}
        public String getID(){return this.id;}

    }
}
