package com.oyaswmi.endcore.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class RuneAltarEntity extends BlockEntity {
    private int number = 7;


    public RuneAltarEntity(BlockPos pos, BlockState state) {
        super(CoreBlocks.RUNE_ALTAR_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current value of the number to the nbt
        nbt.putInt("number", number);

        super.writeNbt(nbt);
    }


}
