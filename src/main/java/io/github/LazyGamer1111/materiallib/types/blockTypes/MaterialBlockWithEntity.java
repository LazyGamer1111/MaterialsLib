package io.github.LazyGamer1111.materiallib.types.blockTypes;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MaterialBlockWithEntity extends MaterialBlock implements BlockEntityProvider {
    public MaterialBlockWithEntity(Settings settings, String name, String parentModel) {
        super(settings, name, parentModel);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
