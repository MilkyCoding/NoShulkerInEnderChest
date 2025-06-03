package me.milkycoding.noshulker.command;

import me.milkycoding.noshulker.util.ChatUtil;
import me.milkycoding.noshulker.util.ConfigUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoShulkerCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("noshulker.admin")) {
                sendNoPermission(sender);
                return true;
            }

            ConfigUtil.reloadConfig();

            String reloadMessage = ConfigUtil.getString("messages.reload-success", "&aКонфигурация успешно перезагружена!");
            ChatUtil.sendMessage(sender, reloadMessage);
            return true;
        }

        sendHelp(sender);
        
        return true;
    }
    
    private void sendHelp(CommandSender sender) {
        String header = ConfigUtil.getString("messages.help-header", "&8&m----------&r &bNoShulkerInEnderChest &8&m----------");
        String reloadHelp = ConfigUtil.getString("messages.help-reload", "&b/noshulker reload &8- &7Перезагрузить конфигурацию");
        String helpHelp = ConfigUtil.getString("messages.help-help", "&b/noshulker help &8- &7Показать это сообщение");
        
        ChatUtil.sendRawMessage(sender, header);
        if (sender.hasPermission("noshulker.admin")) {
            ChatUtil.sendRawMessage(sender, reloadHelp);
        }
        ChatUtil.sendRawMessage(sender, helpHelp);
    }
    
    private void sendNoPermission(CommandSender sender) {
        String message = ConfigUtil.getString("messages.no-permission", "&cУ вас нет прав для использования этой команды!");
        ChatUtil.sendMessage(sender, message);
    }
} 