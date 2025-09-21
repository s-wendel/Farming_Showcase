package shwendel.farming.item;

public class YoggiesEquipmentItemMemory extends YoggiesAbilityItemMemory {

    // The tier of the equipment, e.g. Bronze ? Haven't figured out the tier names yet
    // Each tier unlocks a new ability
    private int tier;
    // The amount of stars on the equipment
    private int level;

    public YoggiesEquipmentItemMemory(YoggiesItem item) {
        super(item);
    }

    // Upgrades etc...

}
