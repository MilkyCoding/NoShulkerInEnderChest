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

/**
 * Обработчик событий эндер сундука
 */
public class EnderChestListener implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Проверяем, является ли инвентарь эндер сундуком
        if (event.getInventory().getType() != InventoryType.ENDER_CHEST) {
            return;
        }
        
        // Получаем предмет, который пытаются поместить
        ItemStack clickedItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        
        // Проверяем оба предмета - и тот, по которому кликнули, и тот, который в курсоре
        if (clickedItem != null && ShulkerUtil.isShulkerBox(clickedItem.getType()) ||
            cursorItem != null && ShulkerUtil.isShulkerBox(cursorItem.getType())) {
            
            Player player = (Player) event.getWhoClicked();
            
            // Проверяем права игрока
            if (!player.hasPermission("noshulker.bypass")) {
                event.setCancelled(true);
                String message = ConfigUtil.getString("messages.shulker-blocked", "&cВы не можете поместить шалкер в эндер сундук!");
                ChatUtil.sendMessage(player, message);
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        // Проверяем, является ли инвентарь эндер сундуком
        if (event.getInventory().getType() != InventoryType.ENDER_CHEST) {
            return;
        }

        // Получаем предмет, который перетаскивают
        ItemStack draggedItem = event.getOldCursor();
        
        // Проверяем, является ли предмет шалкером
        if (draggedItem != null && ShulkerUtil.isShulkerBox(draggedItem.getType())) {
            Player player = (Player) event.getWhoClicked();
            
            // Проверяем права игрока
            if (!player.hasPermission("noshulker.bypass")) {
                event.setCancelled(true);
                String message = ConfigUtil.getString("messages.shulker-blocked", "&cВы не можете поместить шалкер в эндер сундук!");
                ChatUtil.sendMessage(player, message);
            }
        }
    }
} 