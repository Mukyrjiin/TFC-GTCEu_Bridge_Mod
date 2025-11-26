package net.mukyrjiin.tfcgtecubridge.compat;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.material.GTMaterialRegistry;
import net.mukyrjiin.tfcgtecubridge.TFCGTECUBridge;
import net.mukyrjiin.tfcgtecubridge.compat.tfc.TfcOreMapper;
import net.mukyrjiin.tfcgtecubridge.compat.gt.GtOreMapper;

public class TFCCompatModule {

    public static void init() {
        TFCGTECUBridge.LOGGER.info("Loading TFC ↔ GTCEu compatibility module...");

        // Register ore mappings into GTCEu global registries
        registerOreMappings();
    }

    private static void registerOreMappings() {
        TFCGTECUBridge.LOGGER.info("Registering TFC → GT Ore conversions...");

        TfcOreMapper.registerAllMappings();
        GtOreMapper.registerAllGTBackMappings();

        TFCGTECUBridge.LOGGER.info("✓ Completed ore mapping registration.");
    }
}
