package com.skadoosh.net4j.test;

import com.skadoosh.net4j.common.C2SPacket;
import com.skadoosh.net4j.common.PacketIdentifier;
import com.skadoosh.net4j.common.PacketRegistry;
import com.skadoosh.net4j.common.PacketType;
import com.skadoosh.net4j.common.S2CPacket;
import com.skadoosh.net4j.common.builtin.StringMessagePacket;

public final class TestConstants
{
    public static final String NAMESAPCE = "netmark_test";

    public static final PacketType<StringMessagePacket> C2S_TEST_MESSAGE_PACKET_TYPE = PacketRegistry.register(new C2SPacket<>(new PacketIdentifier(NAMESAPCE, "test_packet"), StringMessagePacket.class));
    public static final PacketType<StringMessagePacket> S2C_TEST_MESSAGE_PACKET_TYPE = PacketRegistry.register(new S2CPacket<>(new PacketIdentifier(NAMESAPCE, "test_packet"), StringMessagePacket.class));

    public static void Init()
    {
        // just to load the class
    }
}
