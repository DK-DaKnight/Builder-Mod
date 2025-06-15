package httle.steiner.buildermod;

import com.mojang.logging.LogUtils;
import httle.steiner.buildermod.core.init.ModCreativeTabs;
import httle.steiner.buildermod.core.init.block.BlockInit;
import httle.steiner.buildermod.core.init.item.BlockItemInit;
import httle.steiner.buildermod.core.init.item.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Buildermod.MODID)
public class Buildermod {

    public static final String MODID = "buildermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Buildermod() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModCreativeTabs.TABS.register(bus);
    }
}
