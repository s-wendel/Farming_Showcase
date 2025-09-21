package shwendel.farming;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.joml.Vector2d;
import shwendel.farming.custom_blocks.CustomBlockID;
import shwendel.farming.custom_blocks.CustomBlockManager;
import shwendel.farming.custom_blocks.CustomBlockMemory;
import shwendel.farming.item.gui.AllItemsGUI;
import shwendel.farming.ores.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCommand implements CommandExecutor {

    // Test multiple sounds at once
    public Map<Sound, Vector2d> currentLoadedSoundEffects = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;

        if(!player.hasPermission("admin")) {

            player.sendMessage(ChatColor.RED + "No banks!");

        } else if(args.length == 0) {

            player.sendMessage(ChatColor.WHITE + "/test all_items");
            player.sendMessage(ChatColor.WHITE + "/test new_feature");

        } else {

            switch(args[0].toLowerCase()) {

                case "all_items":

                    new AllItemsGUI(player).open();

                    break;

                case "conveyor":

                    new CustomBlockMemory(CustomBlockManager.getCustomBlock(CustomBlockID.CONVEYOR), player.getLocation().getBlock().getLocation(), BlockFace.valueOf(args[1])).place();

                    break;

                // Tool to help play multiple sounds at once for sound design =)
                case "add_sound_to_playlist":

                    // /hello add_s 2 3

                    if(args.length < 4) {

                        player.sendMessage(ChatColor.WHITE + "/test add_sound_to_playlist <sound_name> <volume> <pitch>");

                        return true;

                    }

                    Sound sound = Sound.valueOf(args[1].toUpperCase());

                    float volume = Float.parseFloat(args[2]);
                    float pitch = Float.parseFloat(args[3]);

                    // Vector2d is an object  that helps store two numbers (I think... ?), Vector3d is three numbers
                    currentLoadedSoundEffects.put(sound, new Vector2d(volume, pitch));

                    player.sendMessage(sound + " added to playlist !");

                    break;

                    /*new BukkitRunnable() {

                        @Override
                        public void run() {

                            player.stopSound(Sound.ENTITY_CREAKING_DEATH);

                        }

                    }.runTaskLater(Farming.getInstance(), 14);*/

                case "play_playlist":

                    player.sendMessage("-=-=-=- Playlist -=-=-=-");

                    for(Map.Entry<Sound, Vector2d> playlistSoundEntry : currentLoadedSoundEffects.entrySet()) {

                        Sound playlistSound = playlistSoundEntry.getKey();

                        Vector2d playlistSoundVolumeAndPitch = playlistSoundEntry.getValue();

                        float playlistSoundVolume = (float) playlistSoundVolumeAndPitch.x();
                        float playlistSoundPitch = (float) playlistSoundVolumeAndPitch.y();

                        player.playSound(player.getLocation(), playlistSound, playlistSoundVolume, playlistSoundPitch);

                        player.sendMessage(playlistSound + "   Volume " + playlistSoundVolume + "  Pitch " + playlistSoundPitch);

                    }

                    player.sendMessage("-=-=-=-=-=-=-=-=-=-=-=-=-");

                    currentLoadedSoundEffects.clear();

                    break;

                case "ore":

                    List<Location> oreLocations = new ArrayList<>();

                    oreLocations.add(player.getTargetBlockExact(10).getLocation());

                    OreMemoryManager.addOreMemory(new OreMemory(OreManager.getOre(OreID.IRON), oreLocations, OreSize.SMALL));

                    player.sendMessage("Ore added!");

                    break;

                case "trail":

                    Location particleLocation = player.getLocation().clone().add(0, 2, 0);

                    //Particle.Trail particle = new Particle.Trail(particleLocation, Color.RED, 100);
                    //player.getWorld().spawnParticle(Particle.TRAIL, particleLocation, 0, particle);

                    break;

                default:

                    break;

            }

        }

        return true;
    }

}
