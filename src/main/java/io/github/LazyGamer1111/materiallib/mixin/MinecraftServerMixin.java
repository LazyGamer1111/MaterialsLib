package io.github.LazyGamer1111.materiallib.mixin;

import io.github.LazyGamer1111.materiallib.Materiallib;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    private static boolean materiallib$initialized = false;

    @Inject(method = "loadWorld", at = @At("TAIL"))
    protected void lateInit(CallbackInfo ci) {
        if (materiallib$initialized) return;
        materiallib$initialized = true;

        Materiallib.lateInit();
    }
}
