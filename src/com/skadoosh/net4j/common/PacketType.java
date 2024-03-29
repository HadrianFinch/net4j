package com.skadoosh.net4j.common;

public abstract class PacketType<T extends Packet>
{
    private final PacketIdentifier identifier;
    private final Class<? extends Packet> type;

    public PacketType(PacketIdentifier identifier, Class<T> type)
    {
        this.identifier = identifier;
        this.type = type;
    }

    public PacketIdentifier getIdentifier()
    {
        return identifier;
    }

    public T construct()
    {
        try
        {
            return (T)(type.getConstructor(PacketIdentifier.class).newInstance(this.identifier));
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
