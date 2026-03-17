package net.crs.limits.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
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
            ItemStack itemstack = player.getItemInHand(InteractionHand.MAIN_HAND);
            BlockState state = pContext.getLevel().getBlockState(posclicked);

            if (state.is(Blocks.SOUL_SAND))
            {
                //change block and subtract item stack by 1
                use(pContext, player, posclicked, itemstack);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public void use(UseOnContext pContext, Player player, BlockPos posclicked, ItemStack itemstack)
    {
        //player.sendSystemMessage(Component.literal(itemstack.toString()));
        pContext.getLevel().setBlock(posclicked, Blocks.SAND.defaultBlockState(), 3);
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        //playsound
    }
}
