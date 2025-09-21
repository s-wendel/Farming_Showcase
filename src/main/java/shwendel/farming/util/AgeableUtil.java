package shwendel.farming.util;

import org.bukkit.Material;
import org.bukkit.block.data.Ageable;

public class AgeableUtil {

    private AgeableUtil() {}

    public static Ageable getAgeable(Material material, int age) {

        Ageable ageable = (Ageable) material.createBlockData();

        ageable.setAge(age);

        return ageable;
    }

}
