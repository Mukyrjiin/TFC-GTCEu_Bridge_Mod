package net.mukyrjiin.tfcgtecubridge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mukyrjiin.tfcgtecubridge.compat.TFCCompatModule;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TFCGTECUBridge.MODID)
public class TFCGTECUBridge {

    public static final String MODID = "tfcgtecubridge";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public TFCGTECUBridge() {
        // Register mod event bus
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Forge event bus
        MinecraftForge.EVENT_BUS.addListener(this::onCommonSetup);

        LOGGER.info("[TFC ↔ GTCEu Bridge] Mod constructor initialized.");
    }

    /**
     * Fires during Forge COMMON setup stage.
     * Good for cross-mod compatibility and registry preparation.
     */
    private void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("[TFC ↔ GTCEu Bridge] Running compat setup...");
            TFCCompatModule.init();
            LOGGER.info("[TFC ↔ GTCEu Bridge] Setup complete.");
        });
    }
}


