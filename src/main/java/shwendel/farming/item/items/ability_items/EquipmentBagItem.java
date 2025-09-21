package shwendel.farming.item.items.ability_items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import shwendel.farming.item.YoggiesAbilityItem;
import shwendel.farming.item.YoggiesAbilityType;
import shwendel.farming.item.YoggiesItemID;
import shwendel.farming.profile.ProfileManager;
import shwendel.farming.profile.ProfileMemory;

public class EquipmentBagItem extends YoggiesAbilityItem {

    @Override
    public String getName() {
        return "Equipment Bag";
    }

    @Override
    public String getDisplayName() {
        return ChatColor.WHITE + "Equipment Bag";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.EQUIPMENT_BAG;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return new ItemStack(Material.BROWN_BUNDLE);
    }

    @Override
    public void runAbility(Entity user, YoggiesAbilityType abilityTypeUsed) {

        switch(abilityTypeUsed) {

            case RIGHT_CLICK:

                Player player = (Player) user;

                ProfileMemory profile = ProfileManager.getProfile(player);

                profile.getEquipmentBag().openEquipmentGUI(player);

                break;

            default:
                break;

        }

    }

}
