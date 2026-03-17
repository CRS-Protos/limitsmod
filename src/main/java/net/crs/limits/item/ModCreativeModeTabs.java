package net.crs.limits.item;

import net.crs.limits.LimitsMod;
import net.crs.limits.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LimitsMod.MODID);

    public static final RegistryObject<CreativeModeTab> LIMITS_TAB = CREATIVE_MODE_TABS.register("limits_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAKESHIFT_NETHER_STAR.get()))
                    .title(Component.translatable("creativetab.limits_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MAKESHIFT_NETHER_STAR.get());
                        pOutput.accept(ModBlocks.FLESH_BLOCK.get());
                        pOutput.accept(ModBlocks.CHEESE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
