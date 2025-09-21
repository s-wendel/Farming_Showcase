package shwendel.farming.custom_blocks.custom_blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Transformation;
import shwendel.farming.custom_blocks.CustomBlock;
import shwendel.farming.custom_blocks.CustomBlockID;
import shwendel.farming.item.YoggiesItemID;

import java.util.ArrayList;
import java.util.List;

public class ConveyorCustomBlock implements CustomBlock {

    @Override
    public CustomBlockID getID() {
        return CustomBlockID.CONVEYOR;
    }

    @Override
    public String getName() {
        return "Conveyor";
    }

    @Override
    public YoggiesItemID getItemIDUsedToPlace() {
        return YoggiesItemID.CONVEYOR;
    }

    @Override
    public List<BlockDisplay> spawnBlockDisplays(Location location) {

        World world = location.getWorld();

        Block block = location.getBlock();

        List<BlockDisplay> blockDisplays = new ArrayList<>();

        // Conveyor belt block display

        BlockDisplay conveyorBelt = (BlockDisplay) world.spawnEntity(block.getLocation(), EntityType.BLOCK_DISPLAY);

        conveyorBelt.setBlock(Material.GRAY_CONCRETE_POWDER.createBlockData());
        conveyorBelt.setRotation(0, 0);

        Transformation conveyorBeltTransformation = conveyorBelt.getTransformation();

        conveyorBeltTransformation.getScale().set(1, (double) 1 / 10, 1);

        conveyorBelt.setTransformation(conveyorBeltTransformation);

        // Conveyor belt connector block display, it's the little gray bit sticking out in the front
        // (It's supposed to show which direction the conveyor's moving in, maybe ? ? Maybe ...)

        BlockDisplay conveyorBeltConnector = (BlockDisplay) world.spawnEntity(block.getLocation().clone().add((double) 1 / 16, 0, (double) -1 / 16), EntityType.BLOCK_DISPLAY);

        conveyorBeltConnector.setBlock(Material.LIGHT_GRAY_CONCRETE.createBlockData());
        //blockDisplay.setRotation(0, 0);

        Transformation conveyorBeltConnectorTransformation = conveyorBeltConnector.getTransformation();

        conveyorBeltConnectorTransformation.getScale().set((double) 14 / 16, (double) 1 / 20, (double) 1 / 16);

        conveyorBeltConnector.setTransformation(conveyorBeltConnectorTransformation);

        blockDisplays.add(conveyorBelt);
        blockDisplays.add(conveyorBeltConnector);

        return blockDisplays;
    }

}
