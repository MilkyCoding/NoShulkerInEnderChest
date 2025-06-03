package me.milkycoding.noshulker.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Утилитный класс для работы с чатом
 */
public class ChatUtil {
    
    private ChatUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Преобразует цветовые коды в сообщении
     * @param message сообщение для преобразования
     * @return сообщение с цветами
     */
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    
    /**
     * Отправляет сообщение с префиксом
     * @param sender получатель сообщения
     * @param message сообщение
     */
    public static void sendMessage(CommandSender sender, String message) {
        String prefix = ConfigUtil.getString("messages.prefix", "&8[&bNoShulker&8] &r");
        sender.sendMessage(colorize(prefix + message));
    }
    
    /**
     * Отправляет сообщение без префикса
     * @param sender получатель сообщения
     * @param message сообщение
     */
    public static void sendRawMessage(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }
} 