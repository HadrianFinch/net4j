package com.skadoosh.net4j.test;
import com.skadoosh.net4j.server.Server;

public class ServerApp
{
    public static void main(String[] args) throws Exception
    {
        TestConstants.Init();

        Server server = new Server();
        server.run(58282);
    }
}
