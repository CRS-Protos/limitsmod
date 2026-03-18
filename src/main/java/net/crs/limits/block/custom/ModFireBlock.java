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
        //todo: figure out how to identify beacon
        int radius = 16; //in blocks
        Map<BlockPos, BlockEntity> bEnts = pLevel.getChunkAt(pPos).getBlockEntities();
        pLevel.players().get(0).sendSystemMessage(Component.literal(bEnts.toString()));

        super.onPlace(pState, pLevel, pPos, pBlockstate, pIsMoving);
    }


}
