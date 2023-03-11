package com.mao.treasure_hunt.common.block;

import com.mao.treasure_hunt.init.EnchantmentInit;
import com.mao.treasure_hunt.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DustSoulSandBlock extends Block {
    private static final IntProperty BREAK = IntProperty.of("break",0,3);
    public DustSoulSandBlock() {
        super(AbstractBlock.Settings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.SOUL_SAND).requiresTool());
        setDefaultState(this.getStateManager().getDefaultState().with(BREAK,0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BREAK);
    }

    private static final VoxelShape SHAPED = Block.createCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);
    private static final VoxelShape BREAK_SHAPED_1 = Block.createCuboidShape(0.0,0.0,0.0,16.0,10.0,16.0);
    private static final VoxelShape BREAK_SHAPED_2 = Block.createCuboidShape(0.0,0.0,0.0,16.0,9.0,16.0);
    private static final VoxelShape BREAK_SHAPED_3 = Block.createCuboidShape(0.0,0.0,0.0,16.0,7.0,16.0);

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
        }
        return SHAPED;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        Item item = player.getMainHandStack().getItem();
        int lever = EnchantmentHelper.getLevel(EnchantmentInit.EXORCISM, stack);
        if (item == ItemInit.BRUSH && lever == 1){
            switch (state.get(BREAK)){
                case 0-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,1));
                    return ActionResult.SUCCESS;
                }
                case 1-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,2));
                    return ActionResult.SUCCESS;
                }
                case 2-> {
                    if (world.isClient) {
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f, 0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,3));
                    return ActionResult.SUCCESS;
                }
            }
        }else if (item == ItemInit.BRUSH){
            switch (state.get(BREAK)){
                case 0-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.damage(DamageSource.MAGIC, 8f);
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,1));
                    return ActionResult.SUCCESS;
                }
                case 1-> {
                    if (world.isClient){
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f,0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.damage(DamageSource.MAGIC, 8f);
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,2));
                    return ActionResult.SUCCESS;
                }
                case 2-> {
                    if (world.isClient) {
                        player.playSound(SoundEvents.BLOCK_SOUL_SAND_BREAK, 1.0f, 0.8f);
                        world.addBlockBreakParticles(pos, state.getBlock().getDefaultState());
                    }
                    player.damage(DamageSource.MAGIC, 8f);
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    world.setBlockState(pos, state.with(BREAK,3));
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.block.dust_soul_sand").formatted(Formatting.LIGHT_PURPLE));
    }
}
