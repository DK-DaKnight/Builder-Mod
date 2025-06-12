package httle.steiner.buildermod.core.init;

import httle.steiner.buildermod.Buildermod;
import httle.steiner.buildermod.core.init.item.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Buildermod.MODID);
    public static final RegistryObject<CreativeModeTab> RUBINE_TAB = TABS.register("rubine_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Rubine"))
                    .icon(() -> new ItemStack(ItemInit.RUBINE_ITEM.get()))
                    .displayItems((params, output) -> {
                        output.accept(ItemInit.RUBINE_ITEM.get());
                        output.accept(ItemInit.RUBINE_ORE_ITEM.get());
                        output.accept(ItemInit.RUBINE_BLOCK_ITEM.get());
                    })
                    .build());


}
