package shwendel.farming.item;

import org.bukkit.inventory.ItemStack;

public class YoggiesItemMemory {

    private YoggiesItem item;
    private int itemAmount;
    // Milliseconds of when the item was created
    private long creationDate;

    public YoggiesItemMemory(YoggiesItem item, int itemAmount, long creationDate) {
        this.item = item;
        this.itemAmount = itemAmount;
        this.creationDate = creationDate;
    }

    // TODO Remove
    public YoggiesItemMemory(YoggiesItem item) {
        this.item = item;
        this.creationDate = System.currentTimeMillis();
    }

    public YoggiesItem getItem() {
        return this.item;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }

    public ItemStack getMinecraftItem() {
        return this.item.getMinecraftItem();
    }

    public long getCreationDate() {
        return this.creationDate;
    }

}
