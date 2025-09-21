package shwendel.farming.loot_tables;

import java.util.*;

public class LootTable<T> {

    private static final Random RANDOM = new Random();

    private List<LootTableEntry<T>> lootTable;
    // The amount of items rolled per loot table call
    private int itemsRolled;

    public LootTable(List<LootTableEntry<T>> lootTable, int itemsRolled) {
        this.lootTable = lootTable;
        this.itemsRolled = itemsRolled;
    }

    public LootTable(LootTableEntry<T>... lootTable) {
        this.lootTable = new ArrayList<>(Arrays.asList(lootTable));
    }

    public List<LootTableEntry<T>> getLootTable() {
        return lootTable;
    }

    /**
     * Returns the total / summed weight of all items, read getRandomItem()'s contract for more details on weight)
     * @return The total / summed weight of all items, read getRandomItem()'s contract for more details on weight)
     */
    private int getTotalWeight() {

        int totalWeight = 0;

        for(LootTableEntry<T> entry : lootTable) {

            totalWeight += entry.getWeight();

        }

        return totalWeight;
    }

    /**
     * Returns a List of generic type T (e.g. new LootTable<String>(), String is T) with a size of X where X is
     * the itemsRolled variable - items are rolled X amount of times using weight and added to the list. If a Loot Table using type T
     * as String is created and three items are added: "Hello" (with weight 5), "11Yogies" (with weight 90), and "Hi" (with weight 10) -
     * getRandomItem() will run the following process X amount of times (where X is still the itemsRolled variable):
     * (The total weight is 105 and a random number is chosen between 0 and 104). If the number is 0-4, "Hello" is added to the List,
     * if the number is 5-95, "11Yogies" is added to the List, and if the number is 96-105, "Hi" is added to the List.
     * @return A List of generic type T (e.g. new LootTable<String>(), String is T) with a size of X where X is
     * the itemsRolled variable
     */
    public List<T> getRandomItem() {

        // I'm using the key as total weight so I easily retrieve a LootTableEntry based on if my random number is < the current totalWeight
        // (Key), (Value) <- Format: e.g. I have
        // 5, "Hello"
        // 50, "Yoggies"
        // 10, "Chess"
        // The map will now show:
        // 5, "Hello"
        // 55, "Yoggies"
        // 65, "Chess"
        // So if I roll a 0-4 (4 < 5), it'll give me Hello; if I roll 5-54 (54 < 55), I'll get "Yoggies", and 55-64 is "Chess" (64 < 55)
        // The (X < Y) in the lines above is showing X being the random number and Y being the current totalWeight key,
        // if the random number is < the current totalWeight key, it gives us our LootTableEntry
        Map<Integer, LootTableEntry<T>> lootTableUsingCurrentTotalWeightAsKey = new LinkedHashMap<>();

        int currentTotalWeight = 0;

        for(LootTableEntry<T> entry : lootTable) {

            currentTotalWeight += entry.getWeight();

            lootTableUsingCurrentTotalWeightAsKey.put(currentTotalWeight, entry);

        }

        List<T> randomItems = new ArrayList<>();

        for(int i = 0; i < this.itemsRolled; i++) {

            int roll = RANDOM.nextInt(currentTotalWeight);

            // So many <> parameterized types !!!!
            Iterator<Map.Entry<Integer, LootTableEntry<T>>> iterator = lootTableUsingCurrentTotalWeightAsKey.entrySet().iterator();

            LootTableEntry<T> randomLootTableEntry = null;

            while(iterator.hasNext() && randomLootTableEntry == null) {

                Map.Entry<Integer, LootTableEntry<T>> entry = iterator.next();

                if(roll < entry.getKey()) {

                    randomLootTableEntry = entry.getValue();

                }

            }

            randomItems.add(randomLootTableEntry.getItem());

        }

        return randomItems;
    }

}