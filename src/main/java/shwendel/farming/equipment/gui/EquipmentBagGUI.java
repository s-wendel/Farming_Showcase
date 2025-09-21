package shwendel.farming.equipment.gui;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import shwendel.farming.item.YoggiesEquipmentItem;
import shwendel.farming.item.YoggiesItem;
import shwendel.farming.item.YoggiesItemID;
import shwendel.farming.item.YoggiesItemManager;
import shwendel.farming.profile.ProfileManager;
import shwendel.farming.profile.ProfileMemory;

import java.util.Iterator;

public class EquipmentBagGUI {

    public EquipmentBagGUI(Player player) {

    }

    public void open() {}


    /*public static final String EQUIPMENT_BAG_GUI_ID = "equipment_bag";
    public static final String EQUIPMENT_BAG_GUI_TITLE = "Equipment Bag";
    public static final int EQUIPMENT_BAG_GUI_ROWS = 3;

    private final int slots;

    private ProfileMemory profile;

    public EquipmentBagGUI(Player player) {

        super(player, EQUIPMENT_BAG_GUI_ID, EQUIPMENT_BAG_GUI_TITLE, EQUIPMENT_BAG_GUI_ROWS);

        this.profile = ProfileManager.getProfile(player);
        this.slots = EQUIPMENT_BAG_GUI_ROWS * 9;

    }

    @Override
    public boolean onClick(InventoryClickEvent event) {

        boolean ableToClick = true;
        boolean equipmentChange = false;

        ItemStack clickedItem = event.getCurrentItem();

        int clickedSlot = event.getRawSlot();

        // Slot is within the Equipment Bag
        if(clickedSlot < slots) {

            *//*ItemStack cursor = event.getCursor();

            boolean cursorIsEquipment = YoggiesItemManager.getItem(cursor) instanceof YoggiesEquipmentItem;

            if(ItemUtil.isItem(cursor) && !cursorIsEquipment) {

                ableToClick = false;

            } else if(cursorIsEquipment || YoggiesItemManager.getItem(clickedItem) instanceof YoggiesEquipmentItem) {

                equipmentChange = true;

            }*//*

            ItemStack cursor = event.getCursor();



        // Slot is outside of the Equipment Bag - the only case we care about is if it's Shift-Clicked inside the Equipment Bag
        } else if(clickedSlot > slots && event.getClick().name().contains("SHIFT")) {

            if(!(YoggiesItemManager.getItem(clickedItem) instanceof YoggiesEquipmentItem)) {

                ableToClick = false;

            } else {

                equipmentChange = true;

            }

        }

        if(!ableToClick) {

            playAwesomeMagicalBarrierSound(player);

        }

        if(equipmentChange) {

            for(ItemStack itemStack : player.getInventory()) {

                YoggiesItem item = YoggiesItemManager.getItem(itemStack);

                if(item != null && item.getItemID() == YoggiesItemID.EQUIPMENT_BAG) {

                    BundleMeta itemStackMeta = (BundleMeta) itemStack.getItemMeta();

                    //itemMeta.setItems();


                }

            }

            player.playSound(player.getLocation(), Sound.ITEM_BUNDLE_INSERT, 1f, 1f);

        }

        return ableToClick;
    }

    @Override
    public boolean onDrag(InventoryDragEvent event) {

        ItemStack cursor = event.getCursor();

        if(cursor == null) {
            return false;
        }

        boolean returnValue = true;

        Iterator<Integer> iterator = event.getRawSlots().iterator();

        while(returnValue && iterator.hasNext()) {

            int draggedSlot = iterator.next();

            if(draggedSlot < slots) {

                returnValue = false;

                playAwesomeMagicalBarrierSound(player);

            }

        }

        return returnValue;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {

        // TODO Load all equipment

        //block.shroomlight.break

    }

    private void playAwesomeMagicalBarrierSound(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_SHROOMLIGHT_BREAK, 1f, 2f);

    }*/

}
