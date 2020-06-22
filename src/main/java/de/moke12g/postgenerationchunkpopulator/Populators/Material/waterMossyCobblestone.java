package de.moke12g.postgenerationchunkpopulator.Populators.Material;

import de.moke12g.postgenerationchunkpopulator.Populators.PopulatorMethod;
import de.moke12g.postgenerationchunkpopulator.Populators.Requirement;
import de.moke12g.postgenerationchunkpopulator.Populators.Requirements.requiredMaterial;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class waterMossyCobblestone implements PopulatorMethod {

    @Override
    public ArrayList<Requirement> requirements() {
        ArrayList<Requirement> arrayList = new ArrayList();
        arrayList.add(new requiredMaterial(Material.COBBLESTONE));
        arrayList.add(new requiredMaterial(Material.WATER));
        return arrayList;
    }

    @Override
    public void run(Chunk chunk, Plugin plugin) {

    }
}
