package shwendel.farming.ores;

import org.bukkit.Location;
import org.bukkit.entity.TextDisplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OreMemory {

    private Ore ore;
    // The blocks in the world that count as part of this ore, used for ore sizes where ores have multiple blocks that count towards the ore
    private List<Location> blocks;
    private OreSize size;
    private int oreMaxHealth;
    // Key (UUID) is a player's UUID, value (Integer) is the amount they're removed from the ore's health
    private Map<UUID, Integer> oreHealthContributed;
    // Attributes are per player
    //private List<OreAttribute> attributes;
    private TextDisplay oreDisplayedName;
    private TextDisplay oreDisplayedHealthBar;

    public OreMemory(Ore ore, List<Location> blocks, OreSize size) {

        this.ore = ore;
        this.blocks = blocks;
        this.size = size;
        this.oreMaxHealth = this.ore.getOreSizes().get(this.size).getOreHealth();
        this.oreHealthContributed = new HashMap<>();



    }

    public Ore getOre() {
        return this.ore;
    }

    public List<Location> getBlocks() {
        return this.blocks;
    }

    public OreSize getSize() {
        return this.size;
    }

    public int getOreMaxHealth() {
        return this.oreMaxHealth;
    }

    /**
     * Adds the parameter (e.g. for a method thisIsAMethod(UUID player, Material material), player and material are the parameters), health,
     * to the stored amount of health a player has taken away from the ore's total max ore health
     * @param player The player who contributed the health
     * @param health The amount of health to add to their total contributions
     */
    public void addOreHealthContributed(UUID player, int health) {

        this.oreHealthContributed.put(player, getOreHealthContributed(player) + health);



    }

    public int getOreHealthContributed(UUID player) {
        return this.oreHealthContributed.getOrDefault(player, 0);
    }

    public int getOreHealth() {

        int currentHealth = this.oreMaxHealth;

        for(int oreHealthContributed : this.oreHealthContributed.values()) {

            currentHealth -= oreHealthContributed;

        }

        return currentHealth;
    }

}
