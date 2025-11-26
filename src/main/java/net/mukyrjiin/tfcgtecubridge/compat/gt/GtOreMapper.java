package net.mukyrjiin.tfcgtecubridge.compat.gt;

import net.mukyrjiin.tfcgtecubridge.TFCGTECUBridge;
import java.util.HashMap;
import java.util.Map;

public class GtOreMapper {

    /**
     * Maps GTCEu materials → TFC ore identifiers.
     * Example:
     * "tin" → "tfc:cassiterite"
     */
    public static final Map<String, String> GT_TO_TFC = new HashMap<>();

    public static void registerAllGTBackMappings() {
        TFCGTECUBridge.LOGGER.info("[Bridge] Registering GTCEu → TFC ore reverse mappings...");

        // -------------------------
        // PHASE 1 reverse lookups
        // -------------------------

        GT_TO_TFC.put("tin", "tfc:cassiterite");
        GT_TO_TFC.put("iron", "tfc:hematite");
        GT_TO_TFC.put("copper", "tfc:malachite");
        GT_TO_TFC.put("lead", "tfc:galena");

        GT_TO_TFC.put("zinc", "tfc:sphalerite");
        GT_TO_TFC.put("aluminium", "tfc:bauxite");

        // -------------------------
        // TODO PHASE 2+:
        // - Material property syncing
        // - Tool/smelting compatibility
        // -------------------------

        TFCGTECUBridge.LOGGER.info("[Bridge] GTCEu → TFC mapping complete. {} entries.", GT_TO_TFC.size());
    }

    /**
     * Public resolver method
     */
    public static String getTFCId(String gtMaterialName) {
        return GT_TO_TFC.get(gtMaterialName);
    }
}

