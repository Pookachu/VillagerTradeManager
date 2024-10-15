package net.astradal.villagerTradeManager;

import net.astradal.villagerTradeManager.listeners.VillagerInteractListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerTradeManager extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new VillagerInteractListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
