package shwendel.farming.item.items.material;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;

public class WheatSeedsItem extends YoggiesItem {

    @Override
    public String getName() {
        return "Wheat Seeds";
    }

    @Override
    public String getDisplayName() {
        return ChatColor.WHITE + "Wheat Seeds";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.WHEAT_SEEDS;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return new ItemStack(Material.BEETROOT_SEEDS);
    }

}
