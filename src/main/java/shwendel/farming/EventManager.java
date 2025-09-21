package shwendel.farming;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import shwendel.farming.crops.listener.CropBreakListener;
import shwendel.farming.crops.listener.CropPlaceListener;
import shwendel.farming.item.listener.AbilityItemRightClickListener;
import shwendel.farming.spells.events.StaffInteractListener;

public class EventManager {

    private static final Listener[] LISTENERS = new Listener[] {
            new AbilityItemRightClickListener(),
            new CropPlaceListener(),
            new CropBreakListener(),
            new StaffInteractListener()
    };

    public static void load() {

        Farming mainClass = Farming.getInstance();

        PluginManager pluginManager = mainClass.getServer().getPluginManager();

        for(Listener listener : LISTENERS) {

            pluginManager.registerEvents(listener, mainClass);

        }

    }

}
