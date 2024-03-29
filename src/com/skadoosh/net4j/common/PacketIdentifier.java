package com.skadoosh.net4j.common;

public final class PacketIdentifier
{
    public final String namespace;
    public final String id;
    
    public PacketIdentifier(String namespace, String id)
    {
        this.namespace = namespace;
        this.id = id;
    }
}
