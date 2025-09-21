package shwendel.farming.soil.soils;

import org.bukkit.Material;
import shwendel.farming.soil.Soil;
import shwendel.farming.soil.SoilID;

public class Mudcracks implements Soil {

    @Override
    public String getDisplayName() {
        return "Mudcracks";
    }

    @Override
    public SoilID getID() {
        return SoilID.MUDCRACKS;
    }

    @Override
    public Material getMaterial() {
        return Material.PACKED_MUD;
    }

}
