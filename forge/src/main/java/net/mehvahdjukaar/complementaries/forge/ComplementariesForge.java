package net.mehvahdjukaar.complementaries.forge;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.client.ComplementariesClient;
import net.mehvahdjukaar.complementaries.client.forge.ComplementariesClientForge;
import net.mehvahdjukaar.complementaries.common.registry.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Complementaries.MOD_ID)
public class ComplementariesForge {
    public ComplementariesForge() {
        Complementaries.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ComplementariesForge::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ComplementariesClientForge::init);
        bus.addListener(ComplementariesForge::onClientSetup);
        bus.addListener(ComplementariesForge::onRegisterAttributes);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        Complementaries.postInit();
        Complementaries.initTerrablender();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        ComplementariesClient.init();
    }

     public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        ModEntityTypes.onRegisterAttributes((entityType, attribute) -> event.put(entityType.get(), attribute.get().build()));
    }
}
