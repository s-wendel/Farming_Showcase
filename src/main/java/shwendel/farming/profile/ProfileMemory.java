package shwendel.farming.profile;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import shwendel.farming.boat.BoatMemory;
import shwendel.farming.crops.ProfileCropMemory;
import shwendel.farming.custom_blocks.CustomBlock;
import shwendel.farming.equipment.gui.EquipmentBag;
import shwendel.farming.item.*;

import java.util.*;

public class ProfileMemory {

    // TODO Profile key, make multiple profiles
    private UUID uuid;
    private EquipmentBag equipmentBag;
    private BoatMemory boat;
    private Map<Location, ProfileCropMemory> crops;
    // All custom blocks created using Block Displays
    private Map<Location, CustomBlock> customBlocks;

    public ProfileMemory(UUID uuid, EquipmentBag equipmentBag, Map<Location, ProfileCropMemory> crops, Map<Location, CustomBlock> customBlocks) {
        this.uuid = uuid;
        this.equipmentBag = equipmentBag;
        this.crops = crops;
        this.customBlocks = customBlocks;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public EquipmentBag getEquipmentBag() {
        return this.equipmentBag;
    }

    public Map<Location, ProfileCropMemory> getCrops() {
        return this.crops;
    }

    public Map<Location, CustomBlock> getCustomBlocks() {
        return this.customBlocks;
    }

    /**
     * Returns a map of all currently equipped items' memory: armor, mainhand item,
     * offhand item, all equipment bag equipment. The key in the map is the item equipped
     * and the value is the type of type of equipped item: armor, mainhand item, offhand, etc...
     * @return A map of all currently equipped items
     */
    public Map<YoggiesItemMemory, YoggiesEquipableItemType> getAllEquippedItems() {

        Player player = Bukkit.getPlayer(uuid);

        Map<YoggiesItemMemory, YoggiesEquipableItemType> getAllEquippedItems = new HashMap<>();

        // TODO Armor + mainhand + offhand loading data
        //System.out.println(player.getInventory().getItemInMainHand());

        // TODO Load specific memory for ability items or equipment

        YoggiesItem mainHandItem = YoggiesItemManager.getItem(player.getInventory().getItemInMainHand());

        if(YoggiesItemManager.isItem(mainHandItem)) {

            YoggiesItemMemory mainHandItemMemory = new YoggiesItemMemory(mainHandItem);

            getAllEquippedItems.put(mainHandItemMemory, YoggiesEquipableItemType.MAIN_HAND);

        }

        for(YoggiesEquipmentItemMemory equipmentItemMemory : getEquipmentBag().getEquipment()) {

            getAllEquippedItems.put(equipmentItemMemory, YoggiesEquipableItemType.EQUIPMENT);

        }

        return getAllEquippedItems;
    }

    /**public List<CropMemory> getCrops() {
        return this.crops;
    }*/

}
