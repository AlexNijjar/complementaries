package net.mehvahdjukaar.complementaries.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.block.CarpetgrassBlock;
import net.mehvahdjukaar.complementaries.common.world.grower.PineTreeGrower;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, Complementaries.MOD_ID);

    public static final ResourcefulRegistry<Block> CUBES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> PILLARS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> STAIRS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> SLABS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> BUTTONS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> PRESSURE_PLATES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> FENCES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> FENCE_GATES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> DOORS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> TRAPDOORS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> SAPLINGS = ResourcefulRegistries.create(BLOCKS);

    public static final RegistryEntry<Block> PINE_PLANKS = CUBES.register("pine_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> PINE_STAIRS = STAIRS.register("pine_stairs", () -> new StairBlock(PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryEntry<Block> PINE_SLAB = SLABS.register("pine_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryEntry<Block> PINE_LOG = PILLARS.register("pine_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryEntry<Block> STRIPPED_PINE_LOG = PILLARS.register("stripped_pine_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryEntry<Block> PINE_WOOD = CUBES.register("pine_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryEntry<Block> STRIPPED_PINE_WOOD = CUBES.register("stripped_pine_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryEntry<Block> PINE_FENCE = FENCES.register("pine_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryEntry<Block> PINE_FENCE_GATE = FENCE_GATES.register("pine_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final RegistryEntry<Block> PINE_BUTTON = BUTTONS.register("pine_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final RegistryEntry<Block> PINE_PRESSURE_PLATE = PRESSURE_PLATES.register("pine_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final RegistryEntry<Block> PINE_DOOR = DOORS.register("pine_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final RegistryEntry<Block> PINE_TRAPDOOR = TRAPDOORS.register("pine_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryEntry<Block> PINE_LEAVES = CUBES.register("pine_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryEntry<Block> PINE_SAPLING = SAPLINGS.register("pine_sapling", () -> new SaplingBlock(new PineTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryEntry<Block> CARPETGRASS = BLOCKS.register("carpetgrass", () -> new CarpetgrassBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET).noCollission().noOcclusion()));
    public static final RegistryEntry<Block> ULTRAVIOLET = BLOCKS.register("ultraviolet", () -> new FlowerBlock(MobEffects.DARKNESS, 10, BlockBehaviour.Properties.copy(Blocks.POPPY)));
}
