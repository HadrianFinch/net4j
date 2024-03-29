package com.skadoosh.net4j.client;

import java.io.IOException;

import com.skadoosh.net4j.common.Packet;

public class ClientThread extends Thread
{
    private final Client client;
    private boolean running = true;

    public ClientThread(Client client)
    {
        this.client = client;
    }

    public void cleanupAndExit()
    {
        running = false;
        this.interrupt();
    }

    @Override
    public void run()
    {
        while (running)
        {
            try
            {
                Packet packet = client.awaitPacket();
                System.out.println(packet.toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}
