package me.milkycoding.noshulkerinenderchest;

import me.milkycoding.noshulkerinenderchest.listeners.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Главный класс плагина NoShulkerInEnderChest.
 * Плагин запрещает ложить шалкеры в эндер сундук.
 *
 * @author MilkyCoding
 * @version 1.0
 */
public final class NoShulkerInEnderChest extends JavaPlugin {

    @Override
    public void onEnable() {
        registerListeners();
    }

    /**
     * Регистрирует слушатели событий плагина.
     */
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }

}
