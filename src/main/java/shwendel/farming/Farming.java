package shwendel.farming;

import org.bukkit.plugin.java.JavaPlugin;

public final class Farming extends JavaPlugin {

    // I think this is the maximum distance players can reach a block
    public static final double MAXIMUM_BLOCK_REACH_DISTANCE = 4.4;

    private static Farming instance;

    @Override
    public void onEnable() {

        instance = this;

        EventManager.load();

        // TODO COmmandManager
        getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Farming getInstance() {
        return instance;
    }

}
