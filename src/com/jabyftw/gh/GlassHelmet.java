package com.jabyftw.gh;

import java.util.logging.Level;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Rafael
 */
public class GlassHelmet extends JavaPlugin implements Listener {
    
    private final ItemStack glass = new ItemStack(Material.GLASS, 1);
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().log(Level.INFO, "Enabled!");
    }
    
    @Override
    public void onDisable() {
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock().getType().equals(Material.GLASS)) {
                if (e.getPlayer().getInventory().getHelmet() == null) {
                    e.getPlayer().getInventory().setHelmet(glass);
                    e.getPlayer().sendMessage("§6New hat!");
                    e.setCancelled(true);
                }
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
