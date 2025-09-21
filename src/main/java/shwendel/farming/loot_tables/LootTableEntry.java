package shwendel.farming.loot_tables;

import shwendel.farming.item.YoggiesItemMemory;

public class LootTableEntry<T> {

    private final T item;
    private final int weight;

    public LootTableEntry(T item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public T getItem() {
        return this.item;
    }

    public int getWeight() {
        return this.weight;
    }

}
