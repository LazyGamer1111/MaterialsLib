package io.github.LazyGamer1111.materiallib;

import net.minecraft.item.Item;

public class materialItem extends Item {
    public final String name;
    public materialItem(Settings settings, String name) {
        super(settings);

        this.name = name;
    }
}
