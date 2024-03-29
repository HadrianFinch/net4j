package com.skadoosh.net4j.common;

public class C2SPacket<T extends Packet> extends PacketType<T>
{
    public C2SPacket(PacketIdentifier identifier, Class<T> type)
    {
        super(identifier, type);
    }
}
