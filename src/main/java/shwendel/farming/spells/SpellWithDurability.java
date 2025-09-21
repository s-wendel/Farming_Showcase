package shwendel.farming.spells;

public abstract class SpellWithDurability extends Spell {

    /**
     * Returns the amount of times a spell can be used before disappearing
     * @return The amount of times a spell can be used before disappearing
     */
    public abstract int getAmountOfUses();

}
