package me.milkycoding.noshulker.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatUtil {
    
    private ChatUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    
    public static void sendMessage(CommandSender sender, String message) {
        String prefix = ConfigUtil.getString("messages.prefix", "&8[&bNoShulker&8] &r");
        sender.sendMessage(colorize(prefix + message));
    }
    
    public static void sendRawMessage(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }
} 