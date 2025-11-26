package net.mukyrjiin.tfcgtecubridge.compat.tfc;

import net.mukyrjiin.tfcgtecubridge.TFCGTECUBridge;
import java.util.HashMap;
import java.util.Map;


public class TfcOreMapper {

    /**
     * Maps TFC ore identifiers → GTCEu Material names.
     * Example:
     * "tfc:cassiterite" → "tin"
     */
    public static final Map<String, String> TFC_TO_GT = new HashMap<>();

    public static void registerAllMappings() {
        TFCGTECUBridge.LOGGER.info("[Bridge] Registering TFC → GTCEu ore mappings...");

        // -------------------------
        // PHASE 1: Primitive Base Mappings
        // -------------------------

        // Example tier-0 metals
        TFC_TO_GT.put("tfc:cassiterite", "tin");
        TFC_TO_GT.put("tfc:hematite", "iron");
        TFC_TO_GT.put("tfc:malachite", "copper");
        TFC_TO_GT.put("tfc:galena", "lead");

        // Example alloy parents
        TFC_TO_GT.put("tfc:sphalerite", "zinc");
        TFC_TO_GT.put("tfc:bauxite", "aluminium");

        // -------------------------
        // TODO: PHASE 2+
        // - Add GT ore variants → TFC veins
        // -------------------------

        TFCGTECUBridge.LOGGER.info("[Bridge] TFC → GTCEu mapping complete. {} entries.", TFC_TO_GT.size());
    }

    /**
     * Public resolver method
     */
    public static String getGTMaterialName(String tfcOreId) {
        return TFC_TO_GT.get(tfcOreId);
    }
}
