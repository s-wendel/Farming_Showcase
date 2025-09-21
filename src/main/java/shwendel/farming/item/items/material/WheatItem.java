package shwendel.farming.item.items.material;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;

public class WheatItem extends YoggiesItem {

    @Override
    public String getName() {
        return "Wheat";
    }

    @Override
    public String getDisplayName() {
        return ChatColor.WHITE + "Wheat";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.WHEAT;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return new ItemStack(Material.WHEAT);
    }

}
