package com.skadoosh.net4j.common;

import com.google.gson.Gson;

public class SerializablePacket
{
    private static final Gson gson = new Gson();

    public final Packet packet;
    public final String classpath;
    
    public SerializablePacket(Packet packet)
    {
        this.packet = packet;
        this.classpath = packet.getClass().getName();
    }

    public String serialize()
    {
        return gson.toJson(this);
    }

    public static Packet deserialize(String data) throws ClassNotFoundException
    {
        SerializablePacket spacket = gson.fromJson(data, SerializablePacket.class);

        Class<?> c = Class.forName(spacket.classpath);
        if (Packet.class.isAssignableFrom(c))
        {
            Packet packet = (Packet)gson.fromJson(gson.toJson(spacket.packet), c);
            
            return packet;
        }
        else
        {
            return null;
        }
    }
}
