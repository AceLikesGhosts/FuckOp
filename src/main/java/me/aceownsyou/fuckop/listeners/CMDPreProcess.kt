package me.aceownsyou.fuckop.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class CMDPreProcess : Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    fun onCommandPreprocess(e: PlayerCommandPreprocessEvent) {
        val args: List<String> = e.message.split(" ");

        if(args[0].lowercase() == "/minecraft:op" && (e.player.hasPermission("*") || e.player.hasPermission("minecraft.command.op"))) {
            val builtargs = StringBuilder();

            for (str: String in args)
                builtargs.append("$str ");

            Bukkit.broadcastMessage("${ChatColor.RED}${ChatColor.BOLD}OPERATOR ${e.player.name} (${e.player.uniqueId}) ATTEMPTED TO RUN /minecraft:op TO BYPASS FuckOP.");
            Bukkit.broadcastMessage("${ChatColor.RED}${ChatColor.BOLD}ARGS: ${builtargs.toString()}")
            e.isCancelled = true;
            return;
        }

        if(args[0].lowercase() == "/minecraft:deop" && (e.player.hasPermission("*") || e.player.hasPermission("minecraft.command.deop"))) {
            val builtargs = StringBuilder();

            for (str: String in args)
                builtargs.append("$str ");

            Bukkit.broadcastMessage("${ChatColor.RED}${ChatColor.BOLD}OPERATOR ${e.player.name} (${e.player.uniqueId}) ATTEMPTED TO RUN /minecraft:deop TO BYPASS FuckOP.");
            Bukkit.broadcastMessage("${ChatColor.RED}${ChatColor.BOLD}ARGS: ${builtargs.toString()}")
            e.isCancelled = true;
            return;
        }
    }
}