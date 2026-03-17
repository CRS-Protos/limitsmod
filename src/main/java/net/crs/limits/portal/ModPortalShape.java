package net.crs.limits.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.portal.PortalShape;

import java.util.Optional;

public class ModPortalShape extends PortalShape
{
    public ModPortalShape(LevelAccessor pLevel, BlockPos pBottomLeft, Direction.Axis pAxis)
    {
        super(pLevel, pBottomLeft, pAxis);
    }

    /// THIS CLASS IS DEPRECATED DO NOT USE

//    @Override
//    public boolean isValid() {
//        return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
//    }
}
