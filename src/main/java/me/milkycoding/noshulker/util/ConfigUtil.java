package me.milkycoding.noshulker.util;

import me.milkycoding.noshulker.NoShulkerInEnderChest;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Утилитный класс для работы с конфигурацией
 */
public class ConfigUtil {
    
    private ConfigUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Получить строку из конфигурации
     * @param path путь к значению
     * @param defaultValue значение по умолчанию
     * @return значение из конфигурации
     */
    public static String getString(String path, String defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getString(path, defaultValue);
    }
    
    /**
     * Получить boolean из конфигурации
     * @param path путь к значению
     * @param defaultValue значение по умолчанию
     * @return значение из конфигурации
     */
    public static boolean getBoolean(String path, boolean defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getBoolean(path, defaultValue);
    }
    
    /**
     * Получить int из конфигурации
     * @param path путь к значению
     * @param defaultValue значение по умолчанию
     * @return значение из конфигурации
     */
    public static int getInt(String path, int defaultValue) {
        FileConfiguration config = NoShulkerInEnderChest.getInstance().getConfig();
        return config.getInt(path, defaultValue);
    }
    
    /**
     * Перезагрузить конфигурацию
     */
    public static void reloadConfig() {
        NoShulkerInEnderChest.getInstance().reloadConfig();
    }
} 