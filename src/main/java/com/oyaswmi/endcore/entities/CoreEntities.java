package com.oyaswmi.endcore.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.oyaswmi.endcore.CoreInit.ModID;

public class CoreEntities {
    public static final EntityType<EndSnowballEntity> EndSnowballEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ModID, "end_snowball"),
            FabricEntityTypeBuilder.<EndSnowballEntity>create(SpawnGroup.MISC, EndSnowballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    public static void RegisterCoreEntities() {

    }
}
