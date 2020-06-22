package de.moke12g.postgenerationchunkpopulator;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.io.File;
import java.util.ArrayList;

public class ChunkUtils {

    static String getChunkFileDesignation(Chunk chunk) {
        new File(chunk.getWorld().getName() + "/chunks/").mkdir();
        return chunk.getWorld().getName() + "/chunks/" + chunk.getX() + "-" + chunk.getZ();
    }

    public static ArrayList<Block> getBlockByType(Material material, Chunk chunk) {
        ArrayList<Block> blocks = new ArrayList<>();
        for (BlockState blockState : chunk.getTileEntities()) {
            if (blockState.getType() == material) blocks.add(blockState.getBlock());
        }
        return blocks;
    }

    boolean isBlockNextToMaterial(Block block, Material material) {
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 1, 0, 0))).getType() == material)
            return true;
        else if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), -1, 0, 0))).getType() == material)
            return true;
        else if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 1, 0))).getType() == material)
            return true;
        else if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, -1, 0))).getType() == material)
            return true;
        else if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, 1))).getType() == material)
            return true;
        else if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, -1))).getType() == material)
            return true;
        else return false;
    }

    Block getBlockNextToMaterial(Block block, Material material) {
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 1, 0, 0))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 1, 0, 0)));
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), -1, 0, 0))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), -1, 0, 0)));
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 1, 0))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 1, 0)));
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, -1, 0))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, -1, 0)));
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, 1))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, 1)));
        if (block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, -1))).getType() == material)
            return block.getWorld().getBlockAt(block.getLocation().add(new Location(block.getWorld(), 0, 0, -1)));
        return null;
    }
}
