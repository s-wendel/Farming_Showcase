package shwendel.farming.crops;

import org.bukkit.block.data.BlockData;
import shwendel.farming.item.YoggiesItemMemory;
import shwendel.farming.loot_tables.LootTable;

import java.util.List;

public class CropStage {

    // The amount of ticks to reach the next stage
    private int ticksToGrow;
    // The block data representing this stage
    private BlockData blockData;
    private List<LootTable<YoggiesItemMemory>> lootTable;

    public CropStage(BlockData blockData, int ticksToGrow, List<LootTable<YoggiesItemMemory>> lootTable) {
        this.blockData = blockData;
        this.ticksToGrow = ticksToGrow;
        this.lootTable = lootTable;
    }

    public BlockData getBlockData() {
        return this.blockData;
    }

    public int getTicksToGrow() {
        return this.ticksToGrow;
    }

    public List<LootTable<YoggiesItemMemory>> getLootTable() {
        return this.lootTable;
    }

}
