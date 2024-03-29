package com.skadoosh.net4j.common;

import java.util.HashMap;

public final class PacketRegistry
{
    private static HashMap<PacketIdentifier, PacketType<? extends Packet>> c2sPacketMap = new HashMap<>();
    private static HashMap<PacketIdentifier, PacketType<? extends Packet>> s2cPacketMap = new HashMap<>();

    public static <T extends Packet> PacketType<T> register(PacketType<T> packetType)
    {
        if (packetType instanceof C2SPacket)
        {
            c2sPacketMap.put(packetType.getIdentifier(), packetType);
        }
        else if (packetType instanceof S2CPacket)
        {
            s2cPacketMap.put(packetType.getIdentifier(), packetType);
        }
        else
        {
            // to signify an error has occured
            return null;
        }

        return packetType;
    }
}
