package net.mehvahdjukaar.complementaries.common.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.util.PlatformUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, Complementaries.MOD_ID);
    public static final Supplier<CreativeModeTab> TAB = new ResourcefulCreativeTab(new ResourceLocation(Complementaries.MOD_ID, "main"))
            .setItemIcon(ModBlocks.PINE_LOG)
            .addRegistry(ITEMS)
            .build();

    public static final ResourcefulRegistry<Item> CUBES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> PILLARS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> STAIRS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> SLABS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BUTTONS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> PRESSURE_PLATES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> FENCES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> FENCE_GATES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> DOORS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> TRAPDOORS = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> PINE_PLANKS = CUBES.register("pine_planks", () -> new BlockItem(ModBlocks.PINE_PLANKS.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_STAIRS = STAIRS.register("pine_stairs", () -> new BlockItem(ModBlocks.PINE_STAIRS.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_SLAB = SLABS.register("pine_slab", () -> new BlockItem(ModBlocks.PINE_SLAB.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_LOG = PILLARS.register("pine_log", () -> new BlockItem(ModBlocks.PINE_LOG.get(), new Item.Properties()));
    public static final RegistryEntry<Item> STRIPPED_PINE_LOG = PILLARS.register("stripped_pine_log", () -> new BlockItem(ModBlocks.STRIPPED_PINE_LOG.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_WOOD = CUBES.register("pine_wood", () -> new BlockItem(ModBlocks.PINE_WOOD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> STRIPPED_PINE_WOOD = CUBES.register("stripped_pine_wood", () -> new BlockItem(ModBlocks.STRIPPED_PINE_WOOD.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_FENCE = FENCES.register("pine_fence", () -> new BlockItem(ModBlocks.PINE_FENCE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_FENCE_GATE = FENCE_GATES.register("pine_fence_gate", () -> new BlockItem(ModBlocks.PINE_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_BUTTON = BUTTONS.register("pine_button", () -> new BlockItem(ModBlocks.PINE_BUTTON.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_PRESSURE_PLATE = PRESSURE_PLATES.register("pine_pressure_plate", () -> new BlockItem(ModBlocks.PINE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_DOOR = DOORS.register("pine_door", () -> new BlockItem(ModBlocks.PINE_DOOR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_TRAPDOOR = TRAPDOORS.register("pine_trapdoor", () -> new BlockItem(ModBlocks.PINE_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_LEAVES = CUBES.register("pine_leaves", () -> new BlockItem(ModBlocks.PINE_LEAVES.get(), new Item.Properties()));
    public static final RegistryEntry<Item> PINE_SAPLING = CUBES.register("pine_sapling", () -> new BlockItem(ModBlocks.PINE_SAPLING.get(), new Item.Properties()));

    public static final RegistryEntry<Item> CARPETGRASS = CUBES.register("carpetgrass", () -> new BlockItem(ModBlocks.CARPETGRASS.get(), new Item.Properties()));
    public static final RegistryEntry<Item> ULTRAVIOLET = CUBES.register("ultraviolet", () -> new BlockItem(ModBlocks.ULTRAVIOLET.get(), new Item.Properties()));

    public static final RegistryEntry<Item> WEIGHTER_BUD = ITEMS.register("weighter_bud", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> WEIGHTER_SPAWN_EGG = ITEMS.register("weighter_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.WEIGHTER, 0x383713, 0x4b3b7e, new Item.Properties()));


}
