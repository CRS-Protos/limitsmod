package net.crs.limits.block.blockent;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PoweredBeacon extends BeaconBlock implements BeaconBeamBlock
{
    public PoweredBeacon(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public DyeColor getColor() {
        return DyeColor.RED;
    }
}
