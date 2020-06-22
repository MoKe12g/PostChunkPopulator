package de.moke12g.postgenerationchunkpopulator.Populators;

import org.bukkit.Chunk;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public interface PopulatorMethod {

    ArrayList<Requirement> requirements();

    void run(Chunk chunk, Plugin plugin);

}
