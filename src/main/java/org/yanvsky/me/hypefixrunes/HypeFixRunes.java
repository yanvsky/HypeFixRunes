package org.yanvsky.me.hypefixrunes;

import org.bukkit.plugin.java.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;

public class HypeFixRunes extends JavaPlugin implements Listener
{
    public static HypeFixRunes instance;

    public void onEnable() {
        (HypeFixRunes.instance = this).saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }

    public void onDisable() {
        HandlerList.unregisterAll();
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item = e.getItem();
        if (!item.getItemMeta().hasDisplayName()) {
            return;
        }
        if (item.getType() != Material.LEGACY_SKULL_ITEM && item.getType() != Material.COMPASS && item.getType() != Material.PAPER && item.getType() != Material.EMERALD) {
            item.getType();
            final Material diamond = Material.DIAMOND;
        }
        if (e.getClickedBlock().getType() != Material.AIR) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        if (HypeFixRunes.instance.getConfig().getBoolean("enable") && b.getType() == Material.LEGACY_SKULL_ITEM) {
            String blockname = e.getBlock().getType().toString();
            blockname = blockname.toLowerCase().replace("_", " ");
            if (blockname.contains("ГЛИФ")) {
                e.setCancelled(true);
            }
        }
    }

    public static HypeFixRunes getInstance() {
        return HypeFixRunes.instance;
    }
}
