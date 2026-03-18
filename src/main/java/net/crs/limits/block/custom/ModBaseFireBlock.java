package net.crs.limits.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ModBaseFireBlock extends BaseFireBlock
{
    public ModBaseFireBlock(BlockBehaviour.Properties pProperties, float pFireDamage)
    {
        super(pProperties, pFireDamage);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving)
    {
        super.onPlace(pState,pLevel,pPos,pOldState,pIsMoving);
    }
}
