package shwendel.farming.ores;

import shwendel.farming.item.YoggiesItemMemory;
import shwendel.farming.loot_tables.LootTable;

import java.util.List;

public class OreSizeMemory {

    private OreSize oreSize;
    private int oreHealth;
    private List<LootTable<YoggiesItemMemory>> lootTable;

    public OreSizeMemory(OreSize oreSize, int oreHealth, List<LootTable<YoggiesItemMemory>> lootTable) {
        this.oreSize = oreSize;
        this.oreHealth = oreHealth;
        this.lootTable = lootTable;
    }

    public OreSize getOreSize() {
        return this.oreSize;
    }

    public int getOreHealth() {
        return this.oreHealth;
    }

    public List<LootTable<YoggiesItemMemory>> getLootTable() {
        return this.lootTable;
    }

}
