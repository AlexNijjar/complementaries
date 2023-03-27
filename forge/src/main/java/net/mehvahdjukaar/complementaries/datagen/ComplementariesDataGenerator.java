package net.mehvahdjukaar.complementaries.datagen;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.datagen.provider.base.ModWorldgenProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.client.ModBlockStateProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.client.ModItemModelProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.client.ModLangProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.server.ModBlockTagProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.server.ModItemTagProvider;
import net.mehvahdjukaar.complementaries.datagen.provider.server.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Complementaries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ComplementariesDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        // Client
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(generator.getPackOutput()));

        // Server
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator.getPackOutput()));
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModWorldgenProvider(packOutput, lookupProvider));
    }
}
