package com.mystic.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.ShaderInstance;

@Environment(EnvType.CLIENT)
public class ModShaders {
    private static ShaderInstance DISTORT_WORLD = null;

    public static void setDimensionalPortal(ShaderInstance distortWorld) {
        DISTORT_WORLD = distortWorld;
    }

    public static ShaderInstance getDistortWorld() {
        return DISTORT_WORLD;
    }
}
