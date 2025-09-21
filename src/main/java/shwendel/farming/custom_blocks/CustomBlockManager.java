package shwendel.farming.custom_blocks;

import shwendel.farming.custom_blocks.custom_blocks.ConveyorCustomBlock;
import shwendel.farming.item.YoggiesItemID;
import shwendel.farming.item.YoggiesItemMemory;

import java.util.HashMap;
import java.util.Map;

public class CustomBlockManager {

    private static final Map<CustomBlockID, CustomBlock> CUSTOM_BLOCKS = new HashMap<>();

    static {

        CUSTOM_BLOCKS.put(CustomBlockID.CONVEYOR, new ConveyorCustomBlock());

    }

    /**
     * Returns a custom block based on the CustomBlockID given, null if no CustomBlock exists with the given ID
     * @param id The CustomBlockID, e.g. CustomBlockID.CONVEYOR
     * @return A custom block based on the CustomBlockID given, null if no CustomBlock exists with the given ID
     */
    public static CustomBlock getCustomBlock(CustomBlockID id) {
        return CUSTOM_BLOCKS.getOrDefault(id, null);
    }

    public static CustomBlock getCustomBlock(YoggiesItemMemory item) {


        return null;
    }

}
