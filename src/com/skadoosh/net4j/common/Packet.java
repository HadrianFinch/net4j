package com.skadoosh.net4j.common;

public class Packet
{
    public Packet(PacketIdentifier identifier)
    {
        this.identifier = identifier;
    }

    public PacketIdentifier identifier;

    public String serialize()
    {
        return new SerializablePacket(this).serialize();
    }
}
