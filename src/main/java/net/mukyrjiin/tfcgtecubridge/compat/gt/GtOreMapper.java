package net.mukyrjiin.tfcgtecubridge.compat.gt;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps GTCEu ore names to a canonical GT ore ID.
 * This is Phase 1 only: no GTCEu API calls yet.
 */
public class GtOreMapper {

    private static final Map<String, String> GT_ORE_MAP = new HashMap<>();

    static {
        // ========================
        //  Example mappings (Phase 1)
        //  Add or change as needed
        // ========================

        GT_ORE_MAP.put("cassiterite", "cassiterite");
        GT_ORE_MAP.put("hematite", "hematite");
        GT_ORE_MAP.put("magnetite", "magnetite");
        GT_ORE_MAP.put("galena", "galena");
        GT_ORE_MAP.put("chalcopyrite", "chalcopyrite");
        GT_ORE_MAP.put("bismuthinite", "bismuthinite");

        // Add more as needed
    }

    /**
     * Returns a normalized GT ore ID or null if unknown.
     */
    public static String getGtId(String oreName) {
        if (oreName == null) return null;
        return GT_ORE_MAP.get(oreName.toLowerCase());
    }

    /** Returns the whole mapping (Phase 1 debugging). */
    public static Map<String, String> getAll() {
        return GT_ORE_MAP;
    }
}

