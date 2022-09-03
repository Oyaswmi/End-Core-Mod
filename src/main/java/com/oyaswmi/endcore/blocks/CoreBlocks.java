package com.oyaswmi.endcore.blocks;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.oyaswmi.endcore.CoreInit.ModID;

public class CoreBlocks {


    //Init Blocks
    public static final CarvedRune AMETHYST_DUST = new CarvedRune(FabricBlockSettings.of(Material.AMETHYST).strength(9.0f).hardness(3.0f));
    public static final CarvedRune CARVED_RUNE = new CarvedRune(FabricBlockSettings.of(Material.STONE).strength(9.0f).hardness(3.0f));
    public static final RuneAltar RUNE_ALTAR = new RuneAltar(FabricBlockSettings.of(Material.STONE).strength(9.0f).hardness(3.0f));
    public static final SnowyEndstone SNOWY_ENDSTONE = new SnowyEndstone(FabricBlockSettings.of(Material.STONE).strength(9.0f).hardness(3.0f).requiresTool());
    public static final EndSnowBlock END_SNOW_BLOCK = new EndSnowBlock(FabricBlockSettings.of(Material.SNOW_BLOCK).strength(0.2f).hardness(0.2f).requiresTool().sounds(BlockSoundGroup.SNOW));
    public static final EndSnowLayer END_SNOW_LAYER = new EndSnowLayer(FabricBlockSettings.of(Material.SNOW_LAYER).strength(0.2f).hardness(0.2f).sounds(BlockSoundGroup.SNOW));

    //Register the fuckers
    public static void RegisterCoreBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(ModID, "amethyst_dust"), AMETHYST_DUST);
        Registry.register(Registry.BLOCK, new Identifier(ModID, "carved_rune"), CARVED_RUNE);
        Registry.register(Registry.BLOCK, new Identifier(ModID, "rune_altar"), RUNE_ALTAR);
        Registry.register(Registry.BLOCK, new Identifier(ModID, "end_snow_block"), END_SNOW_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ModID, "end_snow_layer"), END_SNOW_LAYER);
        Registry.register(Registry.BLOCK, new Identifier(ModID, "snowy_endstone"), SNOWY_ENDSTONE);

    }


}
