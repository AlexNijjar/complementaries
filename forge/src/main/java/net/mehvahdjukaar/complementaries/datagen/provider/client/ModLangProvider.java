package net.mehvahdjukaar.complementaries.datagen.provider.client;

import net.mehvahdjukaar.complementaries.Complementaries;
import net.mehvahdjukaar.complementaries.common.registry.ModBlocks;
import net.mehvahdjukaar.complementaries.common.registry.ModEntityTypes;
import net.mehvahdjukaar.complementaries.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

import java.util.Objects;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, Complementaries.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.complementaries.main", "Complementaries");

        ModBlocks.BLOCKS.stream().forEach(entry -> addBlock(entry, StringUtils.capitaliseAllWords(entry.getId().getPath().replace("_", " "))));
        ModItems.ITEMS.stream().filter(e -> !(e.get() instanceof BlockItem)).forEach(entry -> addItem(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
        ModEntityTypes.ENTITY_TYPES.stream().forEach(entry -> addEntityType(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));


    }
}
