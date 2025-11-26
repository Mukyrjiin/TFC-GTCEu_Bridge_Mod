package net.mukyrjiin.tfcgtecubridge.compat.tfc;

import net.mukyrjiin.tfcgtecubridge.compat.OreMappingRegistry;

/**
 * Reads TFC ores and registers equivalent GT ores.
 * Phase 2: Only mapping registration happens here.
 */
public class TfcOreMapper {

    public static void registerMappings() {
        // TODO: Replace placeholder mappings after inspecting TFC ore registry.

        // Example placeholder mappings that correspond to TFC ore names
        register("native_copper", "copper");
        register("native_gold", "gold");
        register("hematite", "iron");
        register("cassiterite", "tin");

        // Actual TFC ore names may vary — this will be updated in Phase 2B
    }

    private static void register(String tfcOre, String gtOre) {
        OreMappingRegistry.register(tfcOre, gtOre);
    }
}

