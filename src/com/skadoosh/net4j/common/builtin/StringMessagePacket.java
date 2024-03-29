package com.skadoosh.net4j.common.builtin;

import com.skadoosh.net4j.common.Packet;
import com.skadoosh.net4j.common.PacketIdentifier;

public class StringMessagePacket extends Packet
{
    public StringMessagePacket(PacketIdentifier identifier)
    {
        super(identifier);
    }

    private String msg = "";

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "StringMessagePacket [msg=" + msg + "]";
    }
}
