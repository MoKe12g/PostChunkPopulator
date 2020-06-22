package de.moke12g.postgenerationchunkpopulator.Populators;

import org.bukkit.Chunk;

public interface Requirement {

    boolean requirementFulfilled(Chunk chunk);

}
