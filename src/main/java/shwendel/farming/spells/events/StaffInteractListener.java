package shwendel.farming.spells.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import shwendel.farming.spells.spells.OreGatherSpell;

public class StaffInteractListener implements Listener {

    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {

        event.getPlayer().setCooldown(Material.STICK, 25);

        new OreGatherSpell().use(event.getPlayer(), false, 10);

    }

}
