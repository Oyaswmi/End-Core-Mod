package com.oyaswmi.endcore.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

import static com.oyaswmi.endcore.CoreInit.ModID;


public class CoreDim {
    public static  RegistryKey<DimensionOptions> CORE_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ModID, "core_dim"));
    public static RegistryKey<World> CORE_DIM_KEY = RegistryKey.of(Registry.WORLD_KEY, CORE_DIMENSION_KEY.getValue());
    public static  RegistryKey<DimensionType> CORE_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ModID, "core_dim_type"));

    public static void registerCoreDim() {

    }
}