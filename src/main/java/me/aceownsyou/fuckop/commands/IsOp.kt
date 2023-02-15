package me.aceownsyou.fuckop.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class IsOp : CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {
        if(args.size != 1) {
            sender.sendMessage("${ChatColor.RED}Invalid amount of arguments! Usage: /isop <username>")
            return true;
        }

        val player: Player? = Bukkit.getPlayer(args[0]);

        if(player == null) {
            sender.sendMessage("${ChatColor.RED}Failed to find player ${ChatColor.WHITE}\"${args[0]}\"${ChatColor.RED}, are you sure they exist?")
            return true;
        }

        if(!player.isOp) {
            sender.sendMessage("${ChatColor.RED}User ${ChatColor.WHITE}\"${args[0]}\" ${ChatColor.RED}does not have operator status.");
            return true;
        }

        Bukkit.broadcastMessage("${ChatColor.RED}${ChatColor.BOLD}\"${args[0]}\" has operator status.");
        return true;
    }
}