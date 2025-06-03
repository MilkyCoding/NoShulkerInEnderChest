package me.milkycoding.noshulker.util;

import me.milkycoding.noshulker.NoShulkerInEnderChest;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtil {
    
    private ConfigUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    public static String getString(String path, String defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getString(path, defaultValue);
    }
    
    public static boolean getBoolean(String path, boolean defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getBoolean(path, defaultValue);
    }
    
    public static int getInt(String path, int defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getInt(path, defaultValue);
    }
    
    public static void reloadConfig() {
        NoShulkerInEnderChest.getInstance().reloadConfig();
    }
} 