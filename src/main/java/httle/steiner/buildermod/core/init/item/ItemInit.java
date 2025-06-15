package httle.steiner.buildermod.core.init.item;

import httle.steiner.buildermod.Buildermod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Buildermod.MODID);

    public static final RegistryObject<Item> RUBINE_ITEM = ITEMS.register("rubine",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBINE_APPLE = ITEMS.register("rubine_apple",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .build()
            ))
    );

}