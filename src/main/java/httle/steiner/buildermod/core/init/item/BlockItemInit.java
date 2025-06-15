package httle.steiner.buildermod.core.init.item;

import httle.steiner.buildermod.Buildermod;
import httle.steiner.buildermod.core.init.block.BlockInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Buildermod.MODID);

    public static final RegistryObject<Item> RUBINE_ORE_ITEM = ITEMS.register("rubine_ore",
            () -> new BlockItem(BlockInit.RUBINE_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> RUBINE_BLOCK_ITEM = ITEMS.register("rubine_block",
            () -> new BlockItem(BlockInit.RUBINE_BLOCK.get(), new Item.Properties()));
}
