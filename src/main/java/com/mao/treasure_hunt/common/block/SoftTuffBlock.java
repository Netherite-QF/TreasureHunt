package com.mao.treasure_hunt.common.block;

import com.mao.treasure_hunt.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SoftTuffBlock extends Block {
    private static final IntProperty BREAK = IntProperty.of("break",0,5);
    public SoftTuffBlock() {
        super(AbstractBlock.Settings.of(Material.STONE, MapColor.TERRACOTTA_GRAY).sounds(BlockSoundGroup.TUFF).requiresTool().strength(1.3f, 6.0f));
        setDefaultState(this.getStateManager().getDefaultState().with(BREAK,0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BREAK);
    }

    private static final VoxelShape SHAPED = Block.createCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);
    private static final VoxelShape BREAK_SHAPED_1 = Block.createCuboidShape(0.0,0.0,0.0,16.0,13.0,16.0);
    private static final VoxelShape BREAK_SHAPED_2 = Block.createCuboidShape(0.0,0.0,0.0,16.0,12.0,16.0);
    private static final VoxelShape BREAK_SHAPED_3 = Block.createCuboidShape(0.0,0.0,0.0,16.0,11.0,16.0);
    private static final VoxelShape BREAK_SHAPED_4 = Block.createCuboidShape(0.0,0.0,0.0,16.0,10.0,16.0);
    private static final VoxelShape BREAK_SHAPED_5 = Block.createCuboidShape(0.0,0.0,0.0,16.0,9.0,16.0);

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(BREAK)){
            case 1-> {
                return BREAK_SHAPED_1;
            }
            case 2-> {
                return BREAK_SHAPED_2;
            }
            case 3-> {
                return BREAK_SHAPED_3;
            }
            case 4-> {
                return BREAK_SHAPED_4;
            }
            case 5-> {
                return BREAK_SHAPED_5;
            }
        }
        return SHAPED;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(BREAK)){
            case 1-> {
                return BREAK_SHAPED_1;
            }
            case 2-> {
                return BREAK_SHAPED_2;
            }
            case 3-> {
                return BREAK_SHAPED_3;
            }
            case 4-> {
                return BREAK_SHAPED_4;
            }
            case 5-> {
                return BREAK_SHAPED_5;
            }
        }
        return SHAPED;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = player.getStackInHand(hand).getItem();
        if (item == ItemInit.CHISEL){
            switch (state.get(BREAK)){
                case 0-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_TUFF_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,1));
                    return ActionResult.SUCCESS;
                }
                case 1-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_TUFF_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,2));
                    return ActionResult.SUCCESS;
                }
                case 2-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_TUFF_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,3));
                    return ActionResult.SUCCESS;
                }
                case 3-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_TUFF_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,4));
                    return ActionResult.SUCCESS;
                }
                case 4-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_TUFF_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,5));
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }
}
