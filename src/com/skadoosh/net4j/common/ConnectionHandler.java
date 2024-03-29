package com.skadoosh.net4j.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class ConnectionHandler
{
    protected final Socket clientSocket;
    protected final PrintWriter out;
    protected final BufferedReader in;

    public ConnectionHandler(Socket socket) throws IOException
    {
        this.clientSocket = socket;

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public Packet awaitPacket() throws IOException, ClassNotFoundException
    {
        String resp = in.readLine();
        return SerializablePacket.deserialize(resp);
    }

    public void sendPacket(Packet packet)
    {
        String data = packet.serialize();
        out.println(data);
    }

    public void close() throws IOException
    {
        in.close();
        out.close();
        clientSocket.close();
    }
}
