package shwendel.farming.custom_blocks;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;

import java.util.List;

public interface CustomBlock {

    CustomBlockID getID();

    String getName();

    YoggiesItemID getItemIDUsedToPlace();

    List<BlockDisplay> spawnBlockDisplays(Location location);

}
