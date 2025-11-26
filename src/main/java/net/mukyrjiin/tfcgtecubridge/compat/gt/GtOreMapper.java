package net.mukyrjiin.tfcgtecubridge.compat.gt;

import net.mukyrjiin.tfcgtecubridge.compat.OreMappingRegistry;

/**
 * Reads GTCEu ores and registers equivalent TFC ores.
 * Phase 2: Only mapping registration happens here.
 */
public class GtOreMapper {

    public static void registerMappings() {
        // TODO: Replace placeholder mappings with real GTCEu material names.

        // Example placeholder mappings
        register("native_copper", "copper");
        register("native_gold", "gold");
        register("hematite", "iron");
        register("cassiterite", "tin");

        // Add more once we inspect GTCEu's ore list
    }

    private static void register(String tfcOre, String gtOre) {
        OreMappingRegistry.register(tfcOre, gtOre);
    }
}


