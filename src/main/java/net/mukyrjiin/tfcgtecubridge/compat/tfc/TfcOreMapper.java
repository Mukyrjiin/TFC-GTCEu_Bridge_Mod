package net.mukyrjiin.tfcgtecubridge.compat.tfc;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps TerraFirmaCraft ore names to canonical TFC ore IDs.
 * This is Phase 1 only: no TFC API calls yet.
 */
public class TfcOreMapper {

    private static final Map<String, String> TFC_ORE_MAP = new HashMap<>();

    static {
        // ========================
        // Example mappings (Phase 1)
        // Match these to actual TFC ore names
        // ========================

        TFC_ORE_MAP.put("cassiterite", "cassiterite");
        TFC_ORE_MAP.put("hematite", "hematite");
        TFC_ORE_MAP.put("magnetite", "magnetite");
        TFC_ORE_MAP.put("galena", "galena");
        TFC_ORE_MAP.put("chalcopyrite", "chalcopyrite");
        TFC_ORE_MAP.put("bismuthinite", "bismuthinite");

        // Add more as needed
    }

    /**
     * Returns a normalized TFC ore ID or null if unknown.
     */
    public static String getTfcId(String oreName) {
        if (oreName == null) return null;
        return TFC_ORE_MAP.get(oreName.toLowerCase());
    }

    /** Returns the whole mapping (Phase 1 debugging). */
    public static Map<String, String> getAll() {
        return TFC_ORE_MAP;
    }
}
