package net.crs.limits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ModFireBlock extends FireBlock
{
    public ModFireBlock(BlockBehaviour.Properties p_53425_)
    {
        super(p_53425_);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pBlockstate, boolean pIsMoving)
    {
        //check for beacon or makeshift beacon within radius
        //int radius = 16; //in blocks //not needed
        Map<BlockPos, BlockEntity> bEnts = pLevel.getChunkAt(pPos).getBlockEntities(); //checks for block entities
        pLevel.players().get(0).sendSystemMessage(Component.literal("ALL"));
        pLevel.players().get(0).sendSystemMessage(Component.literal(bEnts.toString()));
        pLevel.players().get(0).sendSystemMessage(Component.literal("VALUES"));
        pLevel.players().get(0).sendSystemMessage(Component.literal(bEnts.values().toString()));
        pLevel.players().get(0).sendSystemMessage(Component.literal("END"));
        if (bEnts.values().toString().toLowerCase().contains("beacon"))
        {
            pLevel.players().get(0).sendSystemMessage(Component.literal("BEACON FOUND"));
        }

        super.onPlace(pState, pLevel, pPos, pBlockstate, pIsMoving);
    }


}
