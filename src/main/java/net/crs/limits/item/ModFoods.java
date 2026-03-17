package net.crs.limits.item;

import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(2.0f)
            .build();
}
