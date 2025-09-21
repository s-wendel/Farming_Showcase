package shwendel.farming.ores.ores;

import shwendel.farming.ores.Ore;
import shwendel.farming.ores.OreID;
import shwendel.farming.ores.OreSize;
import shwendel.farming.ores.OreSizeMemory;

import java.util.ArrayList;
import java.util.Map;

public class IronOre implements Ore {

    @Override
    public String getName() {
        return "Iron";
    }

    @Override
    public OreID getOreID() {
        return OreID.IRON;
    }

    @Override
    public Map<OreSize, OreSizeMemory> getOreSizes() {
        return Map.of(
                OreSize.SMALL, new OreSizeMemory(OreSize.SMALL, 1000, new ArrayList<>())
        );
    }

}
