package io.github.LazyGamer1111.materiallib.types.blockTypes;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class MaterialBlockEntity extends BlockEntity {
    public MaterialBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
