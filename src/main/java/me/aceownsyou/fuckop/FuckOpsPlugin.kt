package me.aceownsyou.fuckop

import me.aceownsyou.fuckop.commands.DeOpCommand_OVERRIDE
import me.aceownsyou.fuckop.commands.IsOp
import me.aceownsyou.fuckop.commands.OpCommand_OVERRIDE
import me.aceownsyou.fuckop.listeners.CMDPreProcess
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class FuckOpsPlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("Loaded FuckOps by ace.#0003");

        getCommand("op")?.setExecutor(OpCommand_OVERRIDE());
        getCommand("deop")?.setExecutor(DeOpCommand_OVERRIDE());
        getCommand("isop")?.setExecutor(IsOp());
        server.pluginManager.registerEvents(CMDPreProcess(), this);
    }

    override fun onDisable() {
        logger.info("Unloaded FuckOps.");
        Bukkit.broadcastMessage("${ChatColor.RED}FUCKOPS WAS DISABLED.")
    }
}