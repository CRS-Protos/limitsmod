package net.crs.limits.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class CleansingVial extends Item
{
    public CleansingVial(Properties pProperties)
    {
        super(pProperties.stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide)
        {
            BlockPos posclicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            assert player != null;
            ItemStack itemstack = player.getUseItem();
            BlockState state = pContext.getLevel().getBlockState(posclicked);

            if (state.is(Blocks.SOUL_SAND))
            {
                pContext.getLevel().setBlock(posclicked, Blocks.SAND.defaultBlockState(), 3);
                itemstack.shrink(1);
                //playsound()
            }
        }

        return InteractionResult.SUCCESS;
    }

    public void playsound()
    {

    }


}
