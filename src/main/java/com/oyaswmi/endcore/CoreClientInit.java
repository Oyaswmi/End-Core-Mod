package com.oyaswmi.endcore;

import com.oyaswmi.endcore.entities.CoreEntities;
import com.oyaswmi.endcore.entities.EndSnowballEntity;
import com.oyaswmi.endcore.packets.EndSnowballSpawn;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

import static com.oyaswmi.endcore.CoreInit.ModID;


public class CoreClientInit implements ClientModInitializer {

    Identifier PacketID = new Identifier(ModID, "throw_snowball");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CoreEntities.EndSnowballEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
        receiveEntityPacket();

    }


    public void receiveEntityPacket() {
        ClientPlayNetworking.registerGlobalReceiver(PacketID, (client, network, byteBuf, sender) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EndSnowballSpawn.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EndSnowballSpawn.PacketBufUtil.readAngle(byteBuf);
            float yaw = EndSnowballSpawn.PacketBufUtil.readAngle(byteBuf);
            client.execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos.x, pos.y, pos.z);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.setYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });


}}
