package de.moke12g.postgenerationchunkpopulator.Populators;

import de.moke12g.postgenerationchunkpopulator.Populators.Material.randMossyCobblestone;
import de.moke12g.postgenerationchunkpopulator.Populators.Material.waterMossyCobblestone;

import java.util.ArrayList;

public class Populators {

    public static ArrayList<PopulatorMethod> populatorMethods;

    public static void init() {
        populatorMethods = new ArrayList<>();

        populatorMethods.add(new randMossyCobblestone());
        populatorMethods.add(new waterMossyCobblestone());
        // add new methods here
    }
}
