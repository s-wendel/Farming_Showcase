package shwendel.farming.ores;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OreMemoryManager {

    private static final Map<Location, OreMemory> ORE_MEMORIES;

    static {

        ORE_MEMORIES = new HashMap<>();

        // TODO Comment below out ?

        List<Location> blocks = new ArrayList<>();

        for(int x = 131; x <= 132; x++) {

            for(int y = 161; y <= 162; y++) {

                for(int z = -69; z <= -68; z++) {

                    blocks.add(new Location(Bukkit.getWorld("void"), x, y, z));

                }

            }

        }

        OreMemory oreMemory = new OreMemory(OreManager.getOre(OreID.IRON), blocks, OreSize.SMALL);

        OreMemoryManager.addOreMemory(oreMemory);

    }

    public static void addOreMemory(OreMemory oreMemory) {

        for(Location blockLocation : oreMemory.getBlocks()) {

            Bukkit.broadcastMessage(blockLocation + "");

            ORE_MEMORIES.put(blockLocation, oreMemory);

        }

    }

    public static void removeOreMemory(OreMemory oreMemory) {

        for(Location blockLocation : oreMemory.getBlocks()) {

            ORE_MEMORIES.remove(blockLocation, oreMemory);

            blockLocation.getBlock().setType(Material.AIR);

        }

    }

    public static OreMemory getOreMemory(Location oreLocation) {
        // getOrDefault(x, y) returns the Map value for the key x where e.g. Map<Integer, String> Integer is the key & String is the value,
        // if it doesn't exist returns y instead
        return ORE_MEMORIES.getOrDefault(oreLocation, null);
    }

    public static Map<Location, OreMemory> getOres() {
        return ORE_MEMORIES;
    }

}
