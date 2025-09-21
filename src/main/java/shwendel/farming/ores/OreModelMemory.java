package shwendel.farming.ores;

import org.bukkit.Location;

import java.util.List;

public class OreModelMemory {

    // TODO Support custom blocks at some point ? For detail ?
    private List<OreModelBlockMemory> blocks;
    // The most center point of the model
    private Location center;

    public OreModelMemory(List<OreModelBlockMemory> blocks) {

        this.blocks = blocks;

        //this.center = new Location()

    }

}
