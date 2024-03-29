package com.skadoosh.net4j.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.skadoosh.net4j.common.ConnectionHandler;
import com.skadoosh.net4j.common.Packet;
import com.skadoosh.net4j.common.builtin.StringMessagePacket;
import com.skadoosh.net4j.test.TestConstants;

public class ClientHandler extends ConnectionHandler implements Runnable
{
    public ClientHandler(Socket socket) throws IOException
    {
        super(socket);
    }

    @Override
    public void run()
    {
        try
        {
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                StringMessagePacket packet = TestConstants.C2S_TEST_MESSAGE_PACKET_TYPE.construct();
                packet.setMsg(inputLine);
                
                sendPacket(packet);
            }

            close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            // System.err.println(÷÷);
        }
    }

    public Thread Start()
    {
        Thread thread = new Thread(this);
        thread.start();
        return thread;
    }
}
