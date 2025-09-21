package shwendel.farming.item.items.equipment;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import shwendel.farming.item.YoggiesAbilityType;
import shwendel.farming.item.YoggiesEquipmentItem;
import shwendel.farming.item.YoggiesItemID;

public class RingOfNames extends YoggiesEquipmentItem {

    // World building of why you can see other player's names, allows you to see names of people, or, if they have no name,
    // the name of the species: animals, plants, any living being
    @Override
    public void runAbility(Entity user, YoggiesAbilityType abilityTypeUsed) {

    }

    @Override
    public String getName() {
        return "Ring of Names";
    }

    @Override
    public String getDisplayName() {
        return "Ring of Names";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.RING_OF_NAMES;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return null;
    }

}
