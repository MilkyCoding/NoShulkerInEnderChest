package me.milkycoding.noshulker;

import me.milkycoding.noshulker.command.NoShulkerCommand;
import me.milkycoding.noshulker.listeners.EnderChestListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

/**
 * NoShulkerInEnderChest - Плагин для защиты эндер сундуков от шалкеров
 * @author MilkyCoding
 * @version 1.0.0
 */
public class NoShulkerInEnderChest extends JavaPlugin implements Listener {
    
    private static NoShulkerInEnderChest instance;

    @Override
    public void onEnable() {
        instance = this;
        
        // Сохраняем конфигурацию по умолчанию
        saveDefaultConfig();
        
        // Регистрируем слушатели событий
        getServer().getPluginManager().registerEvents(new EnderChestListener(), this);
        
        // Регистрируем команды
        getCommand("noshulker").setExecutor(new NoShulkerCommand());
        
        getLogger().info("NoShulkerInEnderChest успешно включен!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoShulkerInEnderChest выключен!");
    }

    /**
     * Получить экземпляр плагина
     * @return экземпляр плагина
     */
    public static NoShulkerInEnderChest getInstance() {
        return instance;
    }
} 