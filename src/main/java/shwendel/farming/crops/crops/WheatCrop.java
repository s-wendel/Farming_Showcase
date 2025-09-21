package shwendel.farming.crops.crops;

import org.bukkit.Material;
import shwendel.farming.crops.CropID;
import shwendel.farming.crops.CropStage;
import shwendel.farming.crops.StagedCrop;
import shwendel.farming.item.YoggiesItemID;
import shwendel.farming.item.YoggiesItemManager;
import shwendel.farming.item.YoggiesItemMemory;
import shwendel.farming.loot_tables.LootTable;
import shwendel.farming.loot_tables.LootTableEntry;
import shwendel.farming.util.AgeableUtil;

import java.util.*;

public class WheatCrop extends StagedCrop {

    @Override
    public CropID getID() {
        return CropID.WHEAT;
    }

    @Override
    public List<CropStage> getAllStagesListReference() {

        List<LootTable<YoggiesItemMemory>> seedsLootTable = List.of(new LootTable<>(
                new LootTableEntry<>(new YoggiesItemMemory(
                        YoggiesItemManager.getItem(YoggiesItemID.WHEAT_SEEDS),
                        1, System.currentTimeMillis()),
                        1
                )
        ));

        List<CropStage> allStages = new ArrayList<>();

        // Add wheat ages from 0-7
        for(int i = 0; i <= 7; i++) {

            allStages.add(new CropStage(AgeableUtil.getAgeable(Material.WHEAT, i), 20, seedsLootTable));

        }

        // TODO Add short dry grass block display variant here \/

        return allStages;
    }

}
