package net.mehvahdjukaar.complementaries.fabric;

import net.mehvahdjukaar.complementaries.Complementaries;
import terrablender.api.TerraBlenderApi;

public class TerrablenderEntrypoint implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Complementaries.initTerrablender();
    }
}
