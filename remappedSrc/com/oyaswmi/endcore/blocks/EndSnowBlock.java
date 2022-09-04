package com.oyaswmi.endcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.oyaswmi.endcore.blocks.CoreBlocks.SNOWY_ENDSTONE;
import static net.minecraft.block.Blocks.END_STONE;

public class EndSnowBlock extends Block {

    public EndSnowBlock(Settings settings) {
        super(settings);

    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (world.getBlockState(pos.down(1)).isOf(END_STONE)) {
            world.setBlockState(pos.down(1), SNOWY_ENDSTONE.getDefaultState());
        }else if (world.getBlockState(pos.down(1)).isAir()) {
            world.breakBlock(pos, true);

        }

    }


}
