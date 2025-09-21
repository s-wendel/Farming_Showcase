package shwendel.farming.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class SkullUtil {

    private SkullUtil() {}

    // By D1ggySvk - second message from https://www.spigotmc.org/threads/custom-head-in-1-20.614713 (https://www.spigotmc.org/members/d1ggysvk.505719)
    public static ItemStack getSkull(String texture) {

        final ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), "");

        profile.getProperties().put("textures", new Property("textures", texture));

        Field profileField;

        try {

            profileField = headMeta.getClass().getDeclaredField("profile");

            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

            Bukkit.getLogger().warning("Failed to set base64 skull value!");

        }

        return head;
    }

}
