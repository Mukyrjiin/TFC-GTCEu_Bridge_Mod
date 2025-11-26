package net.mukyrjiin.tfcgtecubridge.compat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Central registry where all ore mappings are stored.
 * This allows GT and TFC mappers to register ore pairs
 * without depending on each other.
 */
public class OreMappingRegistry {

    /** Maps TFC ore → GT ore */
    private static final Map<String, String> TFC_TO_GT = new HashMap<>();

    /** Maps GT ore → TFC ore */
    private static final Map<String, String> GT_TO_TFC = new HashMap<>();

    /** Has phase 2 finished populating these maps? */
    private static boolean locked = false;

    // ============================================================
    // REGISTRATION API — Called ONLY by the mappers
    // ============================================================

    /**
     * Register a pair of ore names.
     * Can only be done before the registry is locked.
     */
    public static void register(String tfcOre, String gtOre) {
        if (locked) {
            throw new IllegalStateException("OreMappingRegistry is locked! Cannot register more mappings.");
        }

        TFC_TO_GT.put(tfcOre, gtOre);
        GT_TO_TFC.put(gtOre, tfcOre);
    }

    /**
     * Called by OreSyncManager once everything is loaded.
     */
    public static void lock() {
        locked = true;
    }

    // ============================================================
    // PUBLIC READ-ONLY VIEW FOR OTHER PARTS OF THE MOD
    // ============================================================

    public static Map<String, String> getTfcToGt() {
        return Collections.unmodifiableMap(TFC_TO_GT);
    }

    public static Map<String, String> getGtToTfc() {
        return Collections.unmodifiableMap(GT_TO_TFC);
    }

    public static String getGtFromTfc(String tfcOre) {
        return TFC_TO_GT.get(tfcOre);
    }

    public static String getTfcFromGt(String gtOre) {
        return GT_TO_TFC.get(gtOre);
    }

    public static boolean hasTfcOre(String tfcOre) {
        return TFC_TO_GT.containsKey(tfcOre);
    }

    public static boolean hasGtOre(String gtOre) {
        return GT_TO_TFC.containsKey(gtOre);
    }
}

