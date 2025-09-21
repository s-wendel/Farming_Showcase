package shwendel.farming.item.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import shwendel.farming.item.*;
import shwendel.farming.profile.ProfileManager;
import shwendel.farming.profile.ProfileMemory;

import java.util.Map;

public class AbilityItemRightClickListener implements Listener {

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event) {

        if(event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }

        Player player = event.getPlayer();

        ProfileMemory profileMemory = ProfileManager.getProfile(player);

        // Loop through all equipment

        // Main hand
        // Off hand ?
        // Armor?
        for(Map.Entry<YoggiesItemMemory, YoggiesEquipableItemType> equippedItem : profileMemory.getAllEquippedItems().entrySet()) {

            YoggiesItem yoggiesItem = equippedItem.getKey().getItem();

            if(yoggiesItem instanceof YoggiesAbilityItem) {

                ((YoggiesAbilityItem) yoggiesItem).runAbility(player, YoggiesAbilityType.RIGHT_CLICK);

            }

        }

    }

}
