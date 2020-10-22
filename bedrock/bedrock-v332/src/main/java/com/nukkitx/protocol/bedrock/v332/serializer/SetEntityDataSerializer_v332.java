package com.nukkitx.protocol.bedrock.v332.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import com.nukkitx.protocol.bedrock.v332.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SetEntityDataSerializer_v332 implements PacketSerializer<SetEntityDataPacket> {
    public static final SetEntityDataSerializer_v332 INSTANCE = new SetEntityDataSerializer_v332();


    @Override
    public void serialize(ByteBuf buffer, SetEntityDataPacket packet) {
        VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
        BedrockUtils.writeEntityData(buffer, packet.getMetadata());
    }

    @Override
    public void deserialize(ByteBuf buffer, SetEntityDataPacket packet) {
        packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
        BedrockUtils.readEntityData(buffer, packet.getMetadata());
    }
}