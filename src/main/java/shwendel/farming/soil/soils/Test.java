package shwendel.farming.soil.soils;

import org.bukkit.Material;
import shwendel.farming.soil.Soil;
import shwendel.farming.soil.SoilID;

public class Test implements Soil {

    @Override
    public String getDisplayName() {
        return "Test";
    }

    @Override
    public SoilID getID() {
        return SoilID.TEST;
    }

    @Override
    public Material getMaterial() {
        return Material.GRASS_BLOCK;
    }

}
