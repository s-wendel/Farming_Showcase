package shwendel.farming.spells;

import org.bukkit.entity.Player;

public abstract class Spell {

    public abstract String getName();
    public abstract SpellID getSpellID();
    public abstract void use(Player player, boolean isCritical, int... values);

    /**
     * Returns the amount of time in milliseconds before a staff can cast any type of spell again after casting this spell
     * @return The amount of time in milliseconds before a staff can cast any type of spell again after casting this spell
     */
    public abstract long getStaffCooldownInMillis();

}
