package de.moke12g.postgenerationchunkpopulator;

import com.sun.media.jfxmedia.logging.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.io.*;

public class ChunkListener implements Listener {

    private PostGenerationChunkPopulator plugin;

    public ChunkListener(PostGenerationChunkPopulator plugin) {
        this.plugin = plugin;
        {
            plugin.getServer().getPluginManager().registerEvents(this, plugin);
        }
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent e) {
        if (new File(ChunkUtils.getChunkFileDesignation(e.getChunk())).exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ChunkUtils.getChunkFileDesignation(e.getChunk()))));
                long chunkUnloadedTime = ServerTimer.serverTime - Long.parseLong(bufferedReader.readLine());
                bufferedReader.close();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ChunkPopulator.startPopulating(chunkUnloadedTime, e.getChunk(), plugin);
                    }
                }, "Populate Chunk " + e.getChunk().getX() + " " + e.getChunk().getZ()).start();
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        } else Logger.logMsg(Logger.DEBUG, "New Chunk generated");
    }


    @EventHandler
    public void onChunkUnLoad(ChunkUnloadEvent e) {
        // Test Code
        try {
            FileWriter chunkInfoWriter = new FileWriter(ChunkUtils.getChunkFileDesignation(e.getChunk()));
            chunkInfoWriter.write(String.valueOf(ServerTimer.serverTime));
            chunkInfoWriter.flush();
            chunkInfoWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}