package net.mehvahdjukaar.complementaries.datagen.provider.server;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends TagsProvider<Item> {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, ForgeRegistries.ITEMS.getRegistryKey(), completableFuture, Complementaries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaTags();
    }

    private void addVanillaTags() {
        ModItems.STAIRS.stream().forEach(b -> tag(ItemTags.STAIRS).add(TagEntry.element(b.getId())));
        ModItems.SLABS.stream().forEach(b -> tag(ItemTags.SLABS).add(TagEntry.element(b.getId())));
        ModItems.BUTTONS.stream().forEach(b -> tag(ItemTags.BUTTONS).add(TagEntry.element(b.getId())));
        ModItems.FENCES.stream().forEach(b -> tag(ItemTags.FENCES).add(TagEntry.element(b.getId())));
        ModItems.FENCE_GATES.stream().forEach(b -> tag(ItemTags.FENCE_GATES).add(TagEntry.element(b.getId())));
        ModItems.DOORS.stream().forEach(b -> tag(ItemTags.DOORS).add(TagEntry.element(b.getId())));
        ModItems.TRAPDOORS.stream().forEach(b -> tag(ItemTags.TRAPDOORS).add(TagEntry.element(b.getId())));
        ModBlocks.SAPLINGS.stream().forEach(b -> tag(ItemTags.SAPLINGS).add(TagEntry.element(b.getId())));
    }
}
