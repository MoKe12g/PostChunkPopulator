package de.moke12g.postgenerationchunkpopulator;

import com.sun.media.jfxmedia.logging.Logger;
import de.moke12g.postgenerationchunkpopulator.Populators.PopulatorMethod;
import de.moke12g.postgenerationchunkpopulator.Populators.Populators;
import de.moke12g.postgenerationchunkpopulator.Populators.Requirement;
import org.bukkit.Chunk;

public class ChunkPopulator {
    static int divisor = 1;

    public static void startPopulating(long timeUnloaded, Chunk chunk, PostGenerationChunkPopulator plugin) {
        Logger.logMsg(Logger.DEBUG, "Populating Chunk " + chunk.getX() + " " + chunk.getZ() + " " + (long) (timeUnloaded / divisor) + " times");
        for (int i = 0; i < (long) (timeUnloaded / divisor); i++) {
            populate(chunk, plugin);
        }
    }

    static void populate(Chunk chunk, PostGenerationChunkPopulator plugin) {
        Logger.logMsg(Logger.DEBUG, "[NOW] Populating Chunk " + chunk.getX() + " " + chunk.getZ());

        for (PopulatorMethod populatorMethod : Populators.populatorMethods) {
            boolean requirementsFulfilled = true;
            for (Requirement requirement : populatorMethod.requirements()) {
                if (requirementsFulfilled) requirementsFulfilled = requirement.requirementFulfilled(chunk);
            }
            System.out.println("Requirements fulfilled = " + requirementsFulfilled + " " + chunk.getX() + " " + chunk.getZ());
            if (requirementsFulfilled) populatorMethod.run(chunk, plugin);
        }
        /*if (chunk.contains(Material.COBBLESTONE.createBlockData()) || chunk.contains(Material.COBBLESTONE_SLAB.createBlockData() || chunk.contains(Material.COBBLESTONE_STAIRS.createBlockData() || chunk.contains(Material.COBBLESTONE_WALL.createBlockData()))))
            chunk.getBlock(8, 100, 8).setType(Material.ACACIA_FENCE);*/
    }
}
