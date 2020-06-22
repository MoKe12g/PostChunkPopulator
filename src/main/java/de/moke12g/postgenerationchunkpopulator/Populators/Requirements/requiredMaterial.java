package de.moke12g.postgenerationchunkpopulator.Populators.Requirements;

import de.moke12g.postgenerationchunkpopulator.Populators.Requirement;
import org.bukkit.Chunk;
import org.bukkit.Material;

public class requiredMaterial implements Requirement {

    Material material;

    public requiredMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean requirementFulfilled(Chunk chunk) {
        System.out.println("Contains Blockdata = " + chunk.contains(material.createBlockData()) + " " + chunk.getX() + " " + chunk.getZ());
        return chunk.contains(material.createBlockData());
    }
}
