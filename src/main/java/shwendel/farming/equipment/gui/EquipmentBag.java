package shwendel.farming.equipment.gui;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import shwendel.farming.item.YoggiesEquipmentItemMemory;

import java.util.ArrayList;
import java.util.List;

public class EquipmentBag {

    private final List<YoggiesEquipmentItemMemory> equipment;

    public EquipmentBag() {
        this(new ArrayList<>());
    }

    public EquipmentBag(List<YoggiesEquipmentItemMemory> equipment) {
        this.equipment = equipment;
    }

    public List<YoggiesEquipmentItemMemory> getEquipment() {
        return this.equipment;
    }

    public void openEquipmentGUI(Player player) {

        player.playSound(player.getLocation(), Sound.ITEM_BUNDLE_INSERT, 1f, 1f);

        new EquipmentBagGUI(player).open();

    }

}
