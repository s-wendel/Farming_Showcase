package shwendel.farming.soil;

import org.bukkit.Material;

import java.util.List;

public interface Soil {

    String getDisplayName();
    SoilID getID();
    Material getMaterial();

}
