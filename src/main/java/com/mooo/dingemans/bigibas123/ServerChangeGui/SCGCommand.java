package com.mooo.dingemans.bigibas123.ServerChangeGui;

import com.mooo.dingemans.bigibas123.ServerChangeGui.Reference.Reference;
import com.mooo.dingemans.bigibas123.ServerChangeGui.config.Config;
import com.mooo.dingemans.bigibas123.ServerChangeGui.util.Chatcreator;
import com.mooo.dingemans.bigibas123.ServerChangeGui.util.MenuWrapper;
import com.mooo.dingemans.bigibas123.ServerChangeGui.util.serverObj;
import me.lucko.helper.messaging.bungee.BungeeMessaging;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SCGCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("SCG")) {
            Chatcreator cc = new Chatcreator(ChatColor.GREEN, "");
            if (args.length >= 1 && args[0].equalsIgnoreCase("reload")) {
                Config.reload();
                BungeeMessaging.getServers(sl -> {
                    for (String s : sl) {
                        Reference.server.put(s, new serverObj(s));
                    }
                });
                cc.append("Reloading config...", ChatColor.YELLOW);
            } else if (args.length >= 1 && args[0].equalsIgnoreCase("save")) {
                Reference.server.values().forEach(serverObj::save);
                Config.save();
                cc.append("Saved Config", ChatColor.GREEN);
            } else if (sender instanceof Player) {
                Player player = (Player) sender;
                if (sender.hasPermission("SCG.use")) {
                    MenuWrapper men = new MenuWrapper(player);
                    men.getMenu().open();
                    return true;
                } else {
                    cc.append("This command is only for players", ChatColor.RED);
                    cc.newLine();
                    cc.append("You are:" + sender.getName(), ChatColor.RED);
                    cc.newLine();
                    cc.append("Type:" + sender.toString(), ChatColor.RED);
                }
            }
            sender.sendMessage(cc.create());
            return true;
        }
        return false;
    }
}