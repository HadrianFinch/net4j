package com.skadoosh.net4j.test;
import java.net.Socket;
import java.util.Scanner;

import com.skadoosh.net4j.client.Client;
import com.skadoosh.net4j.client.ClientThread;
import com.skadoosh.net4j.common.Packet;
import com.skadoosh.net4j.common.builtin.StringMessagePacket;

public class ClientApp
{
    public static void main(String[] args) throws Exception
    {
        TestConstants.Init();

        Client client = new Client("localhost", 58282);

        ClientThread thread = new ClientThread(client);
        thread.start();
        
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        while (run)
        {
            System.out.println("Enter strmsg: ");
            String msg = scan.nextLine();
            
            StringMessagePacket packet = TestConstants.C2S_TEST_MESSAGE_PACKET_TYPE.construct();
            packet.setMsg(msg);
            
            client.sendPacket(packet);
        }
        // Thread.sleep(3000);
        // client.SendPacket();

        thread.interrupt();
        thread.cleanupAndExit();
        client.close();
        scan.close();
        // Server server = new Server();
        // server.run(58282);
    }
}
