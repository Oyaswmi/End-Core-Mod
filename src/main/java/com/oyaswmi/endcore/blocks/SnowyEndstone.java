package com.oyaswmi.endcore.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import static com.oyaswmi.endcore.blocks.CoreBlocks.END_SNOW_BLOCK;
import static com.oyaswmi.endcore.blocks.CoreBlocks.END_SNOW_LAYER;
import static net.minecraft.block.Blocks.END_STONE;

public class SnowyEndstone extends Block {

    public SnowyEndstone(AbstractBlock.Settings settings) {
        super(settings);

    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.getBlockState(pos.up(1)).isOf(END_SNOW_LAYER) && !world.getBlockState(pos.up(1)).isOf(END_SNOW_BLOCK)) {
            world.setBlockState(pos, END_STONE.getDefaultState());

        }
    }
}
