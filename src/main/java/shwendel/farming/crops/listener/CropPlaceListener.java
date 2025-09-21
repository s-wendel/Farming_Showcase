package shwendel.farming.crops.listener;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import shwendel.farming.crops.ProfileCropMemory;
import shwendel.farming.crops.crops.WheatCrop;
import shwendel.farming.profile.ProfileManager;
import shwendel.farming.profile.ProfileMemory;
import shwendel.farming.soil.Soil;
import shwendel.farming.soil.SoilManager;

public class CropPlaceListener implements Listener {

    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {

        Block block = event.getClickedBlock();

        // Do I save event.getClickedBlock() to a variable above this to save negligible memory in case the block is null ?
        // make a ticket in the Discord if you know please bank you
        // Make sure the block was clicked on its top, event.getBlockFace() returns which side it was clicked on
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK || event.getHand() == EquipmentSlot.OFF_HAND || block == null || event.getBlockFace() != BlockFace.UP) {
            return;
        }

        Soil soil = SoilManager.getSoil(block.getType());

        if(soil == null) {
            return;
        }

        Player player = event.getPlayer();

        player.sendMessage("Crop planted !");

        ProfileMemory profile = ProfileManager.getProfile(player.getUniqueId());

        Location location = block.getLocation().clone().add(0, 1, 0);

        profile.getCrops().put(location, new ProfileCropMemory(new WheatCrop(), location, System.currentTimeMillis()));

        ProfileCropMemory cropMemory = profile.getCrops().get(location);

        profile.getCrops().get(location).startCropGrowthScheduledTask();

    }

}
