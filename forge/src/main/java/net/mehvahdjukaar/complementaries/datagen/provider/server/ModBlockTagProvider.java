package net.mehvahdjukaar.complementaries.datagen.provider.server;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;


public class ModBlockTagProvider extends TagsProvider<Block> {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, ForgeRegistries.BLOCKS.getRegistryKey(), completableFuture, Complementaries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaTags();
    }

    private void addVanillaTags() {
        ModBlocks.STAIRS.stream().forEach(b -> tag(BlockTags.STAIRS).add(TagEntry.element(b.getId())));
        ModBlocks.SLABS.stream().forEach(b -> tag(BlockTags.SLABS).add(TagEntry.element(b.getId())));
        ModBlocks.BUTTONS.stream().forEach(b -> tag(BlockTags.BUTTONS).add(TagEntry.element(b.getId())));
        ModBlocks.PRESSURE_PLATES.stream().forEach(b -> tag(BlockTags.PRESSURE_PLATES).add(TagEntry.element(b.getId())));
        ModItems.FENCES.stream().forEach(b -> tag(BlockTags.FENCES).add(TagEntry.element(b.getId())));
        ModItems.FENCE_GATES.stream().forEach(b -> tag(BlockTags.FENCE_GATES).add(TagEntry.element(b.getId())));
        ModItems.DOORS.stream().forEach(b -> tag(BlockTags.DOORS).add(TagEntry.element(b.getId())));
        ModItems.TRAPDOORS.stream().forEach(b -> tag(BlockTags.TRAPDOORS).add(TagEntry.element(b.getId())));
        ModBlocks.SAPLINGS.stream().forEach(b -> tag(BlockTags.SAPLINGS).add(TagEntry.element(b.getId())));

        ModBlocks.SAPLINGS.stream().forEach(b -> tag(BlockTags.LOGS).add(TagEntry.element(b.getId())));

        tag(BlockTags.LEAVES).add(TagEntry.element(ModBlocks.PINE_LEAVES.getId()));
        tag(BlockTags.LOGS).add(TagEntry.element(ModBlocks.PINE_LOG.getId()));
        tag(BlockTags.LOGS).add(TagEntry.element(ModBlocks.PINE_WOOD.getId()));

        ModBlocks.BLOCKS.stream().forEach(b -> {
            Material material = b.get().defaultBlockState().getMaterial();
            if (material == Material.STONE || material == Material.METAL || material == Material.AMETHYST || material == Material.HEAVY_METAL) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TagEntry.element(b.getId()));
            }
            if (material == Material.WOOD) {
                tag(BlockTags.MINEABLE_WITH_AXE).add(TagEntry.element(b.getId()));
            }
            if (material == Material.SAND || material == Material.SNOW || material == Material.GRASS || material == Material.DIRT) {
                tag(BlockTags.MINEABLE_WITH_SHOVEL).add(TagEntry.element(b.getId()));
            }
        });
    }
}
