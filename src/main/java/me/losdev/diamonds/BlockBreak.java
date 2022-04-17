package me.losdev.diamonds;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();

        if(block.getType() == Material.STONE && player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && getChance(10) == true) {

            ItemStack drop = new ItemStack(block.getType());

            drop.setAmount(1);
            drop.setType(Material.DIAMOND);

            player.getPlayer().getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 0);
            player.getWorld().dropItem(block.getLocation(), drop);
            player.sendMessage("So lucky! A diamond!");

        }

    }

    private boolean getChance(final double percent) {
        return Math.random() * 100 < percent;
    }

}