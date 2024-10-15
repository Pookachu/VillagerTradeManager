package net.astradal.villagerTradeManager.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerInteractListener implements Listener {
    @EventHandler
    public void onPlayerVillagerInteract(PlayerInteractEntityEvent event) {
        //make sure the interacted entity is a villager
        if(event.getRightClicked().getType() != EntityType.VILLAGER) {
            return;
        }

        //make sure the villager isn't unemployed
        Villager villager = (Villager) event.getRightClicked();
        if(villager.getProfession() == Villager.Profession.NONE)
        {
            return;
        }

        //make sure the interacting player doesn't have bypass permissions
        Player player = event.getPlayer();
        if(player.hasPermission("villagertrademanager.bypass")) {
            player.sendMessage(Component.text("Bypassing Villager Trading Restrictions.", NamedTextColor.GREEN));
            return;
        }

        //stop the player from interacting with the villager
        event.setCancelled(true);
        player.sendMessage(Component.text("Villager Trading is Disabled on Astradal.", NamedTextColor.RED));
    }
}