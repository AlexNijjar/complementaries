package net.mehvahdjukaar.complementaries.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
    }

    public static class BlockLootTables extends BlockLootSubProvider {
        public BlockLootTables() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            ModBlocks.CUBES.stream().map(RegistryEntry::get).filter(b -> !(b instanceof LeavesBlock)).forEach(this::dropSelf);
            ModBlocks.PILLARS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.STAIRS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.SLABS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.BUTTONS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.PRESSURE_PLATES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.SAPLINGS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.FENCES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.FENCE_GATES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.DOORS.stream().map(RegistryEntry::get).forEach(b -> add(b, createDoorTable(b)));
            ModBlocks.TRAPDOORS.stream().map(RegistryEntry::get).forEach(this::dropSelf);

            this.dropSelf(ModBlocks.CARPETGRASS.get());
            this.dropSelf(ModBlocks.ULTRAVIOLET.get());
            this.add(ModBlocks.PINE_LEAVES.get(), (arg) -> createLeavesDrops(arg, ModBlocks.PINE_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.stream().map(RegistryEntry::get).filter(b -> !(b instanceof LiquidBlock)).toList();
        }
    }
}
