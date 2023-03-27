package net.mehvahdjukaar.complementaries.datagen.provider.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    private static final ResourceLocation BUTTON_INVENTORY = new ResourceLocation("minecraft:block/button_inventory");
    private static final ResourceLocation LEAVES = new ResourceLocation("block/leaves");

    protected static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    private final ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Complementaries.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {


        ModBlocks.CUBES.stream().map(RegistryEntry::get).forEach(this::simpleBlockWithChecks);
        ModBlocks.PILLARS.stream().map(RegistryEntry::get).forEach(b -> logBlock((RotatedPillarBlock) b));
        ModBlocks.STAIRS.stream().map(RegistryEntry::get).forEach(b -> stairsBlock((StairBlock) b, replaceAndCheckPlural(b, "_stairs", "_planks")));
        ModBlocks.SLABS.stream().map(RegistryEntry::get).forEach(b -> slabBlock((SlabBlock) b, replaceAndCheckPlural(b, "_slab", "_planks"), replaceAndCheckPlural(b, "_slab", "_planks")));
        ModBlocks.SAPLINGS.stream().map(RegistryEntry::get).forEach(b -> simpleBlock(b, models().cross(name(b), blockTexture(b))));
        ModBlocks.DOORS.stream().map(RegistryEntry::get).forEach(b -> doorBlock((DoorBlock) b, extend(blockTexture(b), "_bottom"), extend(blockTexture(b), "_top")));
        ModBlocks.TRAPDOORS.stream().map(RegistryEntry::get).forEach(b -> trapdoorBlock((TrapDoorBlock) b, blockTexture(b), true));
        ModBlocks.FENCES.stream().map(RegistryEntry::get).forEach(b -> fenceBlock((FenceBlock) b, replaceAndCheckPlural(b, "_fence", "_planks")));
        ModBlocks.FENCE_GATES.stream().map(RegistryEntry::get).forEach(b -> fenceGateBlock((FenceGateBlock) b, replaceAndCheckPlural(b, "_fence_gate", "_planks")));

        buttonBlock((ButtonBlock) ModBlocks.PINE_BUTTON.get(), blockTexture(ModBlocks.PINE_PLANKS.get()));
        blockNoState(name(ModBlocks.PINE_BUTTON.get()) + "_inventory", replaceAndCheckPlural(ModBlocks.PINE_BUTTON.get(), "_button", "_planks"), BUTTON_INVENTORY, "texture");

        pressurePlateBlock((PressurePlateBlock) ModBlocks.PINE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PINE_PLANKS.get()));

        simpleBlockItem(ModBlocks.CARPETGRASS.get(), new ModelFile.UncheckedModelFile(blockTexture(ModBlocks.CARPETGRASS.get())));
        simpleBlock(ModBlocks.ULTRAVIOLET.get(), models().cross(name(ModBlocks.ULTRAVIOLET.get()), blockTexture(ModBlocks.ULTRAVIOLET.get())));

        ModItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                Block block = ForgeRegistries.BLOCKS.getValue(ForgeRegistries.ITEMS.getKey(blockItem));
                if (block instanceof TrapDoorBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_bottom")));
                } else if (block instanceof FenceBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_inventory")));
                } else if (block instanceof ButtonBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_inventory")));
                } else if (block instanceof DoorBlock) {
                } else if (block instanceof SaplingBlock) {
                } else if (block instanceof SignBlock) {
                } else if (block instanceof ChainBlock) {
                } else if (block instanceof PipeBlock) {
                } else if (block instanceof LanternBlock) {
                } else {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
                }
            }
        });
    }

    private ResourceLocation replaceAndCheckPlural(Block block, String replace) {
        return replaceAndCheckPlural(block, replace, "");
    }

    private ResourceLocation replaceAndCheckPlural(Block block, String replace, String replacement) {
        ResourceLocation path = new ResourceLocation(Complementaries.MOD_ID, blockTexture(block).getPath().replace(replace, replacement));
        if (!exFileHelper.exists(path, TEXTURE)) {
            return new ResourceLocation(Complementaries.MOD_ID, blockTexture(block).getPath().replace(replace, "s"));
        }
        if (!exFileHelper.exists(path, TEXTURE)) {
            return new ResourceLocation(Complementaries.MOD_ID, blockTexture(block).getPath().replace(replace, replacement + "s"));
        }
        if (!exFileHelper.exists(path, TEXTURE)) {
            return new ResourceLocation(Complementaries.MOD_ID, blockTexture(block).getPath().replace(replace, replacement + "s"));
        }
        return path;
    }

    private void simpleBlockWithChecks(Block block) {
        if (block instanceof LeavesBlock) {
            block(block, LEAVES, "all");
            return;
        }
        if (!exFileHelper.exists(blockTexture(block), TEXTURE)) {
            simpleBlock(block, models().cubeAll(name(block), new ResourceLocation(Complementaries.MOD_ID, blockTexture(block).getPath().replace("_wood", "_log"))));
            return;
        }
        simpleBlock(block);
    }

    private void blockNoState(String name, ResourceLocation loc, ResourceLocation parent, String texture) {
        models().getBuilder(name).texture(texture, loc).texture("particle", loc).parent(models().getExistingFile(parent));
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }


    private String name(Block block) {
        return key(block).getPath();
    }

    private void block(Block block, ResourceLocation parent, String texture) {
        simpleBlock(block, models().getBuilder(name(block)).texture(texture, blockTexture(block)).texture("particle", blockTexture(block)).parent(models().getExistingFile(parent)));
    }
}
