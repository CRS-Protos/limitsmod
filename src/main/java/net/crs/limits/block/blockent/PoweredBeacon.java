package net.crs.limits.block.blockent;

import net.crs.limits.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class PoweredBeacon extends BeaconBlock implements BeaconBeamBlock
{

    public static final BooleanProperty POWERED = BooleanProperty.create("powered");


    public PoweredBeacon(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(stateDefinition.any()
                .setValue(POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        // this is where the properties are actually added to the state
        pBuilder.add(POWERED);
    }

//    @Override
//    @Nullable
//    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
//        // code that determines which state will be used when
//        // placing down this block, depending on the BlockPlaceContext
//    }

    @Override
    public DyeColor getColor() {
        return DyeColor.RED;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
    {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            if (pPlayer.isHolding(ModItems.MAKESHIFT_NETHER_STAR.get()))
            {
                pLevel.players().get(0).sendSystemMessage(Component.literal("Holding Makeshift Nether Star"));
            }
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            //if (blockentity instanceof BeaconBlockEntity) {
            //pPlayer.openMenu((BeaconBlockEntity) blockentity);
            //pLevel.players().get(0).sendSystemMessage(Component.literal("Beacon Used"));
            pPlayer.awardStat(Stats.INTERACT_WITH_BEACON);
            //}

            return InteractionResult.CONSUME;
        }
    }
}
