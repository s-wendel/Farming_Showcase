package shwendel.farming.soil;

import org.bukkit.Material;
import shwendel.farming.soil.soils.Mudcracks;

import java.util.HashMap;
import java.util.Map;

public class SoilManager {

    // Class can't be instantiated as an object
    private SoilManager() {}

    private static final Map<SoilID, Soil> ALL_SOILS_USING_ID = new HashMap<>();
    // I feel comfortable using a second map here to reduce lag, it's based on the first map (Check the static { } method)
    // so there shouldn't be any discrepancies
    private static final Map<Material, Soil> ALL_SOILS_USING_MATERIAL = new HashMap<>();

    // static {} is ran one time when the class is called for the first after the plugin loads in,
    // e.g. if I call SoilManager.getSoil(Material.GLASS) it'll run static first once,
    static {

        ALL_SOILS_USING_ID.put(SoilID.MUDCRACKS, new Mudcracks());

        for(Soil soil : ALL_SOILS_USING_ID.values()) {

            ALL_SOILS_USING_MATERIAL.put(soil.getMaterial(), soil);

        }

    }

    public static Soil getSoil(SoilID id) {
        return ALL_SOILS_USING_ID.getOrDefault(id, null);
    }

    public static Soil getSoil(Material material) {
        return ALL_SOILS_USING_MATERIAL.getOrDefault(material, null);
    }

}
