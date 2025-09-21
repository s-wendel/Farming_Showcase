package shwendel.farming.ores;

import java.util.Map;

public interface Ore {

    String getName();
    OreID getOreID();
    Map<OreSize, OreSizeMemory> getOreSizes();

}
