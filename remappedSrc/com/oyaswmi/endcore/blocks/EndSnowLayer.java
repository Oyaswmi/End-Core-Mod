package com.oyaswmi.endcore.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.oyaswmi.endcore.blocks.CoreBlocks.*;
import static net.minecraft.block.Blocks.*;

public class EndSnowLayer extends Block {
    //the current amount of snow layers. le blockstate has arrived.
    public static final IntProperty LAYERS = IntProperty.of("layers", 1, 8);

    public EndSnowLayer(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LAYERS, 1));

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        int layer = state.get(LAYERS);
        switch(layer) {
            case 1:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.125f, 1f);
            case 2:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.250f, 1f);
            case 3:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.375f, 1f);
            case 4:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.500f, 1f);
            case 5:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.625f, 1f);
            case 6:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.750f, 1f);
            case 7:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.875f, 1f);
            case 8:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1f, 1f);
            default:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.125f, 1f);

        }
    }



    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        int layer = state.get(LAYERS);
        switch(layer) {
            case 1:
                return VoxelShapes.cuboid(0f, 0f, 0f, 0f, 0f, 0f);
            case 2:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.125f, 1f);
            case 3:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.250f, 1f);
            case 4:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.375f, 1f);
            case 5:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.500f, 1f);
            case 6:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.625f, 1f);
            case 7:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.750f, 1f);
            case 8:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.875f, 1f);
            default:
                return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.125f, 1f);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ((player.getStackInHand(Hand.MAIN_HAND).isOf(END_SNOW_LAYER.asItem())) && world.getBlockState(pos).get(LAYERS) < 8){
            if (!player.isCreative()) {
                player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
            }
            player.playSound(SoundEvents.BLOCK_SNOW_PLACE, 1, 1);


            world.setBlockState(pos, state.with(LAYERS,  world.getBlockState(pos).get(LAYERS) + 1));
            return ActionResult.SUCCESS;
        }else {
            return ActionResult.FAIL;
        }

    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (state.get(LAYERS) > 1) {
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (world.getBlockState(pos.down(1)).isOf(END_STONE)) {
            world.setBlockState(pos.down(1), SNOWY_ENDSTONE.getDefaultState());
        }

    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.isIn(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)) {
            return false;
        }
        if (blockState.isIn(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)) {
            return true;
        }
        return Block.isFaceFullSquare(blockState.getCollisionShape(world, pos.down()), Direction.UP) || blockState.isOf(this) && blockState.get(LAYERS) == 8;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND: {
                return state.get(LAYERS) < 5;
            }
            case WATER: {
                return false;
            }
            case AIR: {
                return false;
            }
        }
        return false;
    }


    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.getBlockState(pos.down(1)).isAir()) {
            world.breakBlock(pos, false);

        }
    }
}
