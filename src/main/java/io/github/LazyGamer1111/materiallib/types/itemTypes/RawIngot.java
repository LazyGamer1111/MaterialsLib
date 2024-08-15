package io.github.LazyGamer1111.materiallib.types.itemTypes;

import net.fabricmc.fabric.api.item.v1.FabricItem;

public class RawIngot extends SmeltableItem {

    public RawIngot(FabricItem.Settings settings, String name, String langName, String parentModel) {
        super(settings, "raw_" + name, "Raw " + langName, parentModel);
    }
}
