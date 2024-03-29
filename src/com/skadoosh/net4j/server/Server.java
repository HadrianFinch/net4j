package com.skadoosh.net4j.server;

import java.io.IOException;
import java.net.*;

import com.skadoosh.net4j.common.Packet;

public class Server
{
    private ServerSocket serverSocket;

    public void run(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);

        // WARNING: Blocking Operation
        while (true)
        {
            new ClientHandler(serverSocket.accept()).run();
        }
    }

    public void stop() throws IOException
    {
        serverSocket.close();
    }
}
