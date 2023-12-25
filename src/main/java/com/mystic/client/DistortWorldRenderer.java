package com.mystic.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DistortWorldRenderer {
    private static final RenderPhase.ShaderProgram DISTORT_WORLD_SHADER;
    private static final RenderLayer RENDER_LAYER;

    public static void renderModelWithPortalShader(ModelPart model, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, Transformer transformer, float tickDelta, int light, int overlay) {
        transformer.transform(matrixStack);
        model.render(matrixStack, vertexConsumerProvider.getBuffer(RENDER_LAYER), light, overlay);
    }

    static {
        DISTORT_WORLD_SHADER = new RenderPhase.ShaderProgram(ModShaders::getDistortWorld);
        RENDER_LAYER = RenderLayerFactory.create(
                "distort_world",
                VertexFormats.POSITION,
                VertexFormat.DrawMode.QUADS,
                256,
                false,
                false,
                RenderLayer.MultiPhaseParameters.builder()
                        .program(DISTORT_WORLD_SHADER)
                        .build(false)
        );
    }
}
