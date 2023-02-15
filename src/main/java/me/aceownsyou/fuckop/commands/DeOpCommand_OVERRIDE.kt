package me.aceownsyou.fuckop.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DeOpCommand_OVERRIDE: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if(args.size != 1) {
            sender.sendMessage("${ChatColor.RED}Invalid amount of arguments! Usage: /op <username>");
            return true;
        }

        val fetchedPlayer: Player? = Bukkit.getPlayer(args[0]);

        if(fetchedPlayer == null) {
            sender.sendMessage("${ChatColor.RED}Failed to find player ${ChatColor.WHITE}\"${args[0]}\"${ChatColor.RED}, are you sure they exist?");
            return true;
        }

        if(!fetchedPlayer.isOp) {
            sender.sendMessage("${ChatColor.WHITE}\"${fetchedPlayer.name}\" ${ChatColor.RED}is not an operator!");
            return true;
        }

        fetchedPlayer.isOp = false;
        Bukkit.broadcastMessage("${ChatColor.WHITE}\"${fetchedPlayer.name}\" ${ChatColor.GRAY}is no longer an operator.")
        return true;
    }
}