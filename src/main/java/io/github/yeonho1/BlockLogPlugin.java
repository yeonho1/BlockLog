package io.github.yeonho1;

import io.github.yeonho1.event.BlockEventHandler;
import io.github.yeonho1.log.LogManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockLogPlugin extends JavaPlugin {
    BlockEventHandler blockEventHandler;
    public LogManager logManager;

    @Override
    public void onEnable() {
        getLogger().info("BlockLog by yeonho1 enabled");
        logManager = new LogManager(this);
        blockEventHandler = new BlockEventHandler(this);
        getServer().getPluginManager().registerEvents(blockEventHandler, this);
    }

    @Override
    public void onDisable() {
        logManager.save();
        getLogger().info("BlockLog by yeonho1 disabled");
    }

    public void addLog(String log) {
        logManager.addLog(log);
    }
}
