package com.oyaswmi.endcore;

import net.fabricmc.fabric.impl.datagen.FabricTagBuilder;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import static com.oyaswmi.endcore.CoreInit.ModID;

public class CoreBiomeTags {


    public static final TagKey<Biome> IS_FREEZING = TagKey.of(Registry.BIOME_KEY, new Identifier(ModID, "is_freezing"));

    private CoreBiomeTags() {
    }

    private static TagKey<Biome> of(String id) {
        return TagKey.of(Registry.BIOME_KEY, new Identifier(id));
    }
}
