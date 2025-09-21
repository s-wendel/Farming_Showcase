package shwendel.farming.ores.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import shwendel.farming.ores.OreMemory;
import shwendel.farming.ores.OreMemoryManager;

import java.util.Random;

public class MiningOreListener implements Listener {

    private static final Random RANDOM = new Random();

    int test = 0;
    boolean playedCrackSound = false;

    /*@EventHandler
    public void blockDamage(BlockDamageEvent event) {

        // TODO Make this only work for ores
        event.setCancelled(true);

        Player player = event.getPlayer();
        player.sendBlockChange(event.getBlock().getLocation(), event.getBlock().getBlockData());

    }*/

    @EventHandler
    public void playerInteract(PlayerAnimationEvent event) {

        // TODO Trello bugs board
        Block block = event.getPlayer().getTargetBlockExact(5);

        if(block == null || block.getType() == Material.AIR) {
            return;
        }

        Location blockLocation = block.getLocation();

        OreMemory currentOreMemory = OreMemoryManager.getOreMemory(blockLocation);

        if(currentOreMemory == null) {
            return;
        }

        event.setCancelled(true);

        test++;

        if(test < 4) {
            return;
        }

        Player player = event.getPlayer();

        int oreStrength = 2;

        int criticalChanceRoll = RANDOM.nextInt(100);

        if(criticalChanceRoll <= 1) {

            oreStrength *= 20;

            player.playSound(blockLocation, Sound.BLOCK_COPPER_GRATE_BREAK, 1.5f, 0.75f);

        }

        currentOreMemory.addOreHealthContributed(player.getUniqueId(), oreStrength);

        int oreHealth = currentOreMemory.getOreHealth();

        float blockProgress = 1 - (float) oreHealth / currentOreMemory.getOreMaxHealth();

        if(blockProgress >= 1) {

            OreMemoryManager.removeOreMemory(currentOreMemory);

        } else {

            for(Location oreBlockLocation : currentOreMemory.getBlocks()) {

                player.sendBlockDamage(oreBlockLocation, blockProgress, RANDOM.nextInt());

            }

            player.playSound(blockLocation, Sound.BLOCK_IRON_BREAK, 0.25f, 2f);

            int random = RANDOM.nextInt(25);

            if(random <= 5) {

                player.playSound(blockLocation, Sound.BLOCK_COPPER_BREAK, 0.25f, 1.25f);

            }

            // Cracking sound?
            /*if(!playedCrackSound && blockProgress >= 0.1) {

                player.playSound(blockLocation, Sound.ENTITY_WITHER_BREAK_BLOCK, 0.15f, 0.75f);

                new BukkitRunnable() {

                    @Override
                    public void run() {

                        player.stopSound(Sound.ENTITY_WITHER_BREAK_BLOCK);

                    }

                }.runTaskLater(Farming.getInstance(), 7);

                playedCrackSound = true;

            }*/

            //BLOCK_BASALT_BREAK

            // Rock sounds?
            /*player.playSound(blockLocation, Sound.BLOCK_BASALT_BREAK, 0.25f, 1f);

            int random = RANDOM.nextInt(5);

            if(random == 0) {

                player.playSound(blockLocation, Sound.BLOCK_BASALT_BREAK, 0.25f, 0.5f);

            }*/


        }

        test = 0;

    }

}
