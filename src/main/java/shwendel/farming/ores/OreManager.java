package shwendel.farming.ores;

import shwendel.farming.ores.ores.IronOre;

import java.util.HashMap;
import java.util.Map;

public class OreManager {

    private static final Map<OreID, Ore> ORES;

    static {

        ORES = new HashMap<>();

        ORES.put(OreID.IRON, new IronOre());

    }

    public static Ore getOre(OreID id) {
        // getOrDefault(x, y) returns the Map value for the key x where e.g. Map<Integer, String> Integer is the key & String is the value,
        // if it doesn't exist returns y instead
        return ORES.getOrDefault(id, null);
    }

    public static Map<OreID, Ore> getOres() {
        return ORES;
    }

}
