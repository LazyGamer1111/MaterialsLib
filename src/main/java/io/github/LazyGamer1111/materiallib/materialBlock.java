package io.github.LazyGamer1111.materiallib;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;

public class materialBlock extends Block {
    public final String name;

    public materialBlock(Settings settings, String name) {
        super(settings);
        this.name = name;
    }
}
