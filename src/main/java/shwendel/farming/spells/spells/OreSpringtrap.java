package shwendel.farming.spells.spells;

import org.bukkit.entity.Player;
import shwendel.farming.spells.Spell;
import shwendel.farming.spells.SpellID;

public class OreSpringtrap extends Spell {


    // Kind of like a finisher spell for ores, gives a bonus?
    @Override
    public String getName() {
        return "Ore Springtrap";
    }

    @Override
    public SpellID getSpellID() {
        return null;
    }

    @Override
    public void use(Player player, boolean isCritical, int... values) {

    }

    @Override
    public long getStaffCooldownInMillis() {
        return 0;
    }

}
