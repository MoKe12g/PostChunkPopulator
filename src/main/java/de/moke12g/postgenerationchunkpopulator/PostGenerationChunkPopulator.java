package de.moke12g.postgenerationchunkpopulator;

import de.moke12g.postgenerationchunkpopulator.Populators.Populators;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PostGenerationChunkPopulator extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChunkListener(this), this);

        Populators.init();
        ServerTimer.start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        ServerTimer.stop();
    }
}
