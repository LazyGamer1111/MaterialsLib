package io.github.LazyGamer1111.materiallib.client.mixin;

import io.github.LazyGamer1111.materiallib.client.MateriallibClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void lateInit(CallbackInfo info) {
        MateriallibClient.lateInit();
    }
}
