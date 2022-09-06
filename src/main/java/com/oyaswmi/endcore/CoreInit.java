package com.oyaswmi.endcore;

import com.oyaswmi.endcore.blocks.CoreBlocks;
import com.oyaswmi.endcore.enchantments.CoreEnchants;
import com.oyaswmi.endcore.entities.CoreEntities;
import com.oyaswmi.endcore.items.CoreItems;

import com.oyaswmi.endcore.world.dimension.CoreDim;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CoreInit implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("endcore");

	//Mod's ID for file reference
	public static final String ModID = "endcore";



	@Override
	public void onInitialize() {

		CoreEnchants.RegisterCoreEnchants();
		CoreEntities.RegisterCoreEntities();
		CoreBlocks.RegisterCoreBlocks();
		CoreItems.RegisterCoreItems();

		LOGGER.info("Hello Fabric world!");
		CoreDim.registerCoreDim();
	}
}
