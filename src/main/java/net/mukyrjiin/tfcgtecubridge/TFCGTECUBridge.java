package net.mukyrjiin.tfcgtecubridge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mukyrjiin.tfcgtecubridge.compat.gt.GtOreMapper;
import net.mukyrjiin.tfcgtecubridge.compat.tfc.TfcOreMapper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main mod entry point for the TFC ↔ GTCEu Bridge.
 *
 * Phase 1:
 *  - Mod loads
 *  - Prints current ore mappings
 *  - Verifies everything is wired correctly
 */
@Mod(TFCGTECUBridge.MODID)
public class TFCGTECUBridge {

    public static final String MODID = "tfcgtceubridge";

    public static final Logger LOGGER = LogManager.getLogger();

    public TFCGTECUBridge() {
        // Register lifecycle event listeners
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        LOGGER.info("[TFC-GTCEu Bridge] Mod initialized (Phase 1).");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("[TFC-GTCEu Bridge] Running common setup...");

        // Print ore mappings for Phase 1 debug
        printMappings();
    }

    private void printMappings() {
        LOGGER.info("========== TFC ↔ GTCEu Phase 1 Ore Mappings ==========");

        LOGGER.info("GTCEu Ore Map:");
        GtOreMapper.getAll().forEach((k, v) ->
                LOGGER.info("  GT -> {} = {}", k, v)
        );

        LOGGER.info("TFC Ore Map:");
        TfcOreMapper.getAll().forEach((k, v) ->
                LOGGER.info("  TFC -> {} = {}", k, v)
        );

        LOGGER.info("======================================================");
    }
}

