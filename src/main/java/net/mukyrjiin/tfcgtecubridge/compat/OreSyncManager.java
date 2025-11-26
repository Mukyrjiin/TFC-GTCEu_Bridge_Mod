package net.mukyrjiin.tfcgtecubridge.compat;

import java.util.Map;

public class OreSyncManager {

    private static boolean finalized = false;

    /**
     * Called during FMLCommonSetupEvent after both mappers run.
     * Locks the registry and logs the final mapping table.
     */
    public static void finalizeMappings() {
        if (finalized) {
            return;
        }

        finalized = true;

        // Lock registry so no more entries can be added
        OreMappingRegistry.lock();

        logMappings();
    }

    /**
     * Logs the mapping table once at startup for debugging.
     */
    private static void logMappings() {
        System.out.println("[TFC-GTCEu Bridge] Final Ore Mapping Table:");
        for (Map.Entry<String, String> entry : OreMappingRegistry.getMappings().entrySet()) {
            System.out.println("  TFC → GT : " + entry.getKey() + "  ->  " + entry.getValue());
        }
    }

    /** Utility; external check if registry is frozen */
    public static boolean isFinalized() {
        return finalized;
    }
}


