package shwendel.farming.crops.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import shwendel.farming.itembuilder.ItemBuilder;

import java.util.UUID;

public class CropBreakListener implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        Block block = event.getBlock();

        ItemBuilder itemBuilder = new ItemBuilder(new ItemStack(Material.WHEAT));

        itemBuilder.setItemKey("test", PersistentDataType.STRING, UUID.randomUUID().toString());

        Item item = block.getLocation().getWorld().dropItem(block.getLocation().clone().add(0.5, 0.25, 0.5), itemBuilder.toItemStack());

        item.setVelocity(item.getVelocity().multiply(0.75));


        //player.getInventory().addItem(new ItemStack(Material.WHEAT));

    }

    @EventHandler
    public void blockDropItem(BlockDropItemEvent event) {

        event.setCancelled(true);

    }

}
