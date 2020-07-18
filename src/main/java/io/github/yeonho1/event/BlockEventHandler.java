package io.github.yeonho1.event;

import io.github.yeonho1.BlockLogPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class BlockEventHandler implements Listener {
    BlockLogPlugin plugin;
    public BlockEventHandler(BlockLogPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBlock().getType();
        String log = player.getDisplayName() + " placed " + blockType.toString();
        plugin.getLogger().info(log);
        plugin.logManager.addLog(log);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBlock().getType();
        String log = player.getDisplayName() + " broke " + blockType.toString();
        plugin.getLogger().info(log);
        plugin.addLog(log);
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBucket();
        String log = player.getDisplayName() + " filled " + blockType.toString();
        plugin.getLogger().info(log);
        plugin.addLog(log);
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBucket();
        String log = player.getDisplayName() + " emptied " + blockType.toString();
        plugin.getLogger().info(log);
        plugin.addLog(log);
    }
}
