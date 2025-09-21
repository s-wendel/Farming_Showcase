package shwendel.farming.item.items.machines;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;

public class ConveyorItem extends YoggiesItem {

    @Override
    public String getName() {
        return "Conveyor";
    }

    @Override
    public String getDisplayName() {
        return "Conveyor";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.CONVEYOR;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return new ItemStack(Material.GRAY_CARPET);
    }

}
