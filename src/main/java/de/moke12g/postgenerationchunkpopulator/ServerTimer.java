package de.moke12g.postgenerationchunkpopulator;

import com.sun.media.jfxmedia.logging.Logger;

import java.io.*;

public class ServerTimer {

    static long serverTime; // ticks if the server is running, if the server is stopped, the time will be saved
    static boolean serverIsRunning = false; //TODO: Save the ServerTime
    static int multiplicator = 20;

    static void init() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("serverTime")));
            serverTime = Long.parseLong(bufferedReader.readLine());
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            serverTime = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void start() {
        serverIsRunning = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (serverIsRunning) {
                    try {
                        Thread.sleep(multiplicator * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    serverTime++;
                    Logger.logMsg(Logger.DEBUG, "servertime = " + serverTime);
                }
            }
        }, "ServerTimer").start();
    }

    static void stop() {
        serverIsRunning = false;
        try {
            FileWriter serverTimeWriter = new FileWriter("serverTime");
            serverTimeWriter.write(String.valueOf(ServerTimer.serverTime));
            serverTimeWriter.flush();
            serverTimeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
