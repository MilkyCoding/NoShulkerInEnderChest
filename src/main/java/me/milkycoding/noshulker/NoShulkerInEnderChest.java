package me.milkycoding.noshulker;

import me.milkycoding.noshulker.command.NoShulkerCommand;
import me.milkycoding.noshulker.listeners.EnderChestListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class NoShulkerInEnderChest extends JavaPlugin implements Listener {
    
    private static NoShulkerInEnderChest instance;

    @Override
    public void onEnable() {
        instance = this;
        
        saveDefaultConfig();
        
        getServer().getPluginManager().registerEvents(new EnderChestListener(), this);
        
        getCommand("noshulker").setExecutor(new NoShulkerCommand());
        
        getLogger().info("NoShulkerInEnderChest успешно включен!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoShulkerInEnderChest выключен!");
    }

    public static NoShulkerInEnderChest getInstance() {
        return instance;
    }
} 