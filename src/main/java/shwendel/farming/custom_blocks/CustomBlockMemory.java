package shwendel.farming.custom_blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class CustomBlockMemory {

    private CustomBlock customBlock;
    private Location location;
    private BlockFace blockDirection;
    private List<BlockDisplay> blockDisplays;

    public CustomBlockMemory(CustomBlock customBlock, Location location, BlockFace blockDirection) {

        this.customBlock = customBlock;
        this.location = location;
        this.blockDirection = blockDirection;
        this.blockDisplays = new ArrayList<>();

    }

    public CustomBlock getCustomBlock() {
        return this.customBlock;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<BlockDisplay> getBlockDisplays() {
        return this.blockDisplays;
    }

    public void place() {

        this.blockDisplays = this.customBlock.spawnBlockDisplays(this.location);

        final int degrees = this.blockDirection.ordinal() * 90;

        for(BlockDisplay blockDisplay : this.blockDisplays) {

            // Ordinal is the index of the enum used, e.g. if I make an enum class called Number with ONE, TWO, FIVE
            // Number.ONE's ordinal value would be 0, Number.TWO would be 1, Number.FIVE would be 2
            rotateEntityAroundPoint(blockDisplay, this.location.clone().add(0.5, 0, 0.5), degrees);

        }

        // Used as the block's hitbox
        this.location.getBlock().setType(Material.TRIPWIRE);

    }

    public void remove() {

        this.location.getBlock().setType(Material.AIR);

        for(BlockDisplay blockDisplay : this.blockDisplays) {

            blockDisplay.remove();

        }

    }

    // Made by ChatGPT, my advice (you don't have to take it, it's your decision) is you don't use it unless you understand the content
    // I know vector math a little, but I don't want to learn it right now, it's my decision to detriment myself of learning vectors
    private void rotateEntityAroundPoint(Entity entity, Location origin, double degrees) {
        // Get the entity's current location relative to the origin
        Location entityLoc = entity.getLocation();
        Vector relativePos = entityLoc.toVector().subtract(origin.toVector());

        // Convert degrees to radians
        double radians = Math.toRadians(degrees);

        // Rotate around the Y axis (horizontal rotation)
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        // Apply rotation matrix
        double x = relativePos.getX() * cos - relativePos.getZ() * sin;
        double z = relativePos.getX() * sin + relativePos.getZ() * cos;

        // Update the relative position
        relativePos.setX(x).setZ(z);

        // Calculate new absolute position
        Vector newPos = origin.toVector().add(relativePos);

        // Teleport the entity to the new position
        Location newLoc = new Location(origin.getWorld(),
                newPos.getX(),
                entityLoc.getY(),
                newPos.getZ(),
                entityLoc.getYaw() + (float)degrees,
                entityLoc.getPitch());
        entity.teleport(newLoc);
    }

}
