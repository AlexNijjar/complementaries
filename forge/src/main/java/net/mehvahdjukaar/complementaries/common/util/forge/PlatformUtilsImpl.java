package net.mehvahdjukaar.complementaries.common.util.forge;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.mehvahdjukaar.complementaries.mixin.forge.AxeItemAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static void registerStrippedLog(Block log, Block strippedLog) {
        Map<Block, Block> strippedBlocks = new HashMap<>(AxeItemAccessor.getStrippables());
        strippedBlocks.put(log, strippedLog);
        AxeItemAccessor.setStrippables(strippedBlocks);
    }

    public static <T extends Mob> void registerSpawnPlacement(RegistryEntry<EntityType<T>> entityType, SpawnPlacements.Type decoratorType, Heightmap.Types heightMapType, SpawnPlacements.SpawnPredicate<T> decoratorPredicate) {
        SpawnPlacements.register(entityType.get(), decoratorType, heightMapType, decoratorPredicate);
    }

    public static Supplier<Item> createSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, int primaryColor, int secondaryColor, Item.Properties properties) {
        return () -> new ForgeSpawnEggItem(type, primaryColor, secondaryColor, properties);
    }
}
