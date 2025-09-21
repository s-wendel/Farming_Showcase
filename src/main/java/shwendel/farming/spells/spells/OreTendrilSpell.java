package shwendel.farming.spells.spells;

import org.bukkit.FluidCollisionMode;
import org.bukkit.entity.Player;
import shwendel.farming.ores.OreMemory;
import shwendel.farming.ores.OreMemoryManager;
import shwendel.farming.spells.Spell;
import shwendel.farming.spells.SpellID;

public class OreTendrilSpell extends Spell {

    @Override
    public String getName() {
        return "Ore Tendril";
    }

    @Override
    public SpellID getSpellID() {
        return SpellID.ORE_GATHER;
    }

    @Override
    public void use(Player player, boolean isCritical, int... values) {

        OreMemory oreMemory = OreMemoryManager.getOreMemory(player.getTargetBlockExact(10, FluidCollisionMode.NEVER).getLocation());

        player.sendMessage(oreMemory + "");

    }

    @Override
    public long getStaffCooldownInMillis() {
        return 0;
    }

}
