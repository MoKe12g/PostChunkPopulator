package de.moke12g.postgenerationchunkpopulator.Populators.Material;

import de.moke12g.postgenerationchunkpopulator.ChunkUtils;
import de.moke12g.postgenerationchunkpopulator.Populators.PopulatorMethod;
import de.moke12g.postgenerationchunkpopulator.Populators.Requirement;
import de.moke12g.postgenerationchunkpopulator.Populators.Requirements.requiredMaterial;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class randMossyCobblestone implements PopulatorMethod {

    @Override
    public ArrayList<Requirement> requirements() {
        ArrayList<Requirement> arrayList = new ArrayList();
        arrayList.add(new requiredMaterial(Material.COBBLESTONE));
        return arrayList;
    }

    @Override
    public void run(Chunk chunk, Plugin plugin) {
        System.out.println("PopulationMethod randMossyCobbleStone was started for " + chunk.getX() + " " + chunk.getZ());
        /*new Thread(new BukkitRunnable() {
            @Override
            public void run() {
                ArrayList<Block> blocks = ChunkUtils.getBlockByType(Material.COBBLESTONE, chunk);
                if (blocks.size() > 0) {
                    Block blockToChance = blocks.get(new Random().nextInt(blocks.size()) + 1);
                    blockToChance.setType(Material.MOSSY_COBBLESTONE);
                    System.out.println("Blocks were changed " + blockToChance.getLocation().toString());
                }
            }
        }).start();*/
        new BukkitRunnable() {
            @Override
            public void run() {
                ArrayList<Block> blocks = ChunkUtils.getBlockByType(Material.COBBLESTONE, chunk);
                System.out.println("Got " + blocks.size() + " blocks for cobblestone");
                if (blocks.size() > 0) {
                    Block blockToChance = blocks.get(new Random().nextInt(blocks.size()) + 1);
                    blockToChance.setType(Material.MOSSY_COBBLESTONE);
                    System.out.println("Blocks were changed " + blockToChance.getLocation().toString());
                }
            }
        }.runTaskTimer(plugin, 0, 5);

    }
}
