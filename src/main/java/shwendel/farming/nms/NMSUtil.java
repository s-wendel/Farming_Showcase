package shwendel.farming.nms;

import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSUtil {

    public static void sendBlockBreakAnimationPacket(Player player, Location location, int stage) {
        ((CraftPlayer) player).getHandle().f.sendPacket(
                new PacketPlayOutBlockBreakAnimation(
                        player.getEntityId(),
                        new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ()), stage
                )
        );
    }

}
