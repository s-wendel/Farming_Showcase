package shwendel.farming.item.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;
import shwendel.farming.item.YoggiesItemManager;
import shwendel.farming.item.YoggiesItemMemory;

import java.util.Map;

public class AllItemsGUI {

    public AllItemsGUI(Player player) {}

    public void open() {}

    /*public static final String ALL_ITEMS_GUI_NAME = "All Items";
    public static final String ALL_ITEMS_GUI_ID = "all_items_gui";
    public static final int ALL_ITEMS_GUI_ROWS = 6;

    public AllItemsGUI(Player player) {
        super(player, ALL_ITEMS_GUI_ID, ALL_ITEMS_GUI_NAME, ALL_ITEMS_GUI_ROWS);
    }

    @Override
    public boolean onClick(InventoryClickEvent event) {
        return true;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {

        for(Map.Entry<YoggiesItemID, YoggiesItem> item : YoggiesItemManager.getAllItems().entrySet()) {

            addItem(item.getValue().getMinecraftItem());

        }

    }*/

}
