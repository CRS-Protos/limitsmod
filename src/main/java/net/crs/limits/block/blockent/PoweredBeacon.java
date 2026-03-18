package net.crs.limits.block.blockent;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

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
}
