package net.mehvahdjukaar.complementaries;

import net.mehvahdjukaar.complementaries.common.registry.*;
import net.mehvahdjukaar.complementaries.common.util.PlatformUtils;
import net.mehvahdjukaar.complementaries.common.world.terrablender.ComplementariesRegion;
import terrablender.api.Regions;

public class Complementaries {
    public static final String MOD_ID = "complementaries";

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModEntityTypes.ENTITY_TYPES.init();
        ModFeatures.FEATURES.init();
        ModTrunkPlacers.TRUNK_PLACERS.init();
    }

    public static void postInit() {
        PlatformUtils.registerStrippedLog(ModBlocks.PINE_LOG.get(), ModBlocks.STRIPPED_PINE_LOG.get());
        ModEntityTypes.registerSpawnPlacements();
    }
    
    public static void initTerrablender() {
        Regions.register(new ComplementariesRegion(10));
    }
}
