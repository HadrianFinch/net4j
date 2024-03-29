package com.skadoosh.net4j.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.skadoosh.net4j.common.ConnectionHandler;
import com.skadoosh.net4j.common.Packet;
import com.skadoosh.net4j.common.SerializablePacket;

public class Client extends ConnectionHandler
{
    public Client(String address, int port) throws IOException
    {
        super(new Socket(address, port));
    }

}
