package me.milkycoding.noshulker.listeners;

import me.milkycoding.noshulker.util.ChatUtil;
import me.milkycoding.noshulker.util.ConfigUtil;
import me.milkycoding.noshulker.util.ShulkerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class EnderChestListener implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() != InventoryType.ENDER_CHEST) {
            return;
        }
        
        Player player = (Player) event.getWhoClicked();
        
        ItemStack clickedItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        ItemStack hotbarItem = event.getHotbarButton() != -1 ? player.getInventory().getItem(event.getHotbarButton()) : null;
        
        if ((clickedItem != null && ShulkerUtil.isShulkerBox(clickedItem.getType())) ||
            (cursorItem != null && ShulkerUtil.isShulkerBox(cursorItem.getType())) ||
            (hotbarItem != null && ShulkerUtil.isShulkerBox(hotbarItem.getType()))) {
            
            if (!player.hasPermission("noshulker.bypass")) {
                event.setCancelled(true);
                String message = ConfigUtil.getString("messages.shulker-blocked", "&cВы не можете поместить шалкер в эндер сундук!");
                ChatUtil.sendMessage(player, message);
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (event.getInventory().getType() != InventoryType.ENDER_CHEST) {
            return;
        }

        ItemStack draggedItem = event.getOldCursor();
        
        if (draggedItem != null && ShulkerUtil.isShulkerBox(draggedItem.getType())) {
            Player player = (Player) event.getWhoClicked();
            
            if (!player.hasPermission("noshulker.bypass")) {
                event.setCancelled(true);
                String message = ConfigUtil.getString("messages.shulker-blocked", "&cВы не можете поместить шалкер в эндер сундук!");
                ChatUtil.sendMessage(player, message);
            }
        }
    }
} 