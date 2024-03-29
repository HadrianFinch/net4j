package com.skadoosh.net4j.common;

public class S2CPacket<T extends Packet> extends PacketType<T>
{
    public S2CPacket(PacketIdentifier identifier, Class<T> type)
    {
        super(identifier, type);
    }
}
