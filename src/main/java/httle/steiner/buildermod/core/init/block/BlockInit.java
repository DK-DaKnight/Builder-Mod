package httle.steiner.buildermod.core.init.block;

import httle.steiner.buildermod.Buildermod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Buildermod.MODID);

//    public static final RegistryObject<Block> SMILE_BLOCK = BLOCKS.register("smile_block",
//            () -> new Block(BlockBehaviour.Properties
//                    .ofFullCopy(Blocks.STONE)
//                    .strength(0.2F, 0.001F)
//            ));

    public static final RegistryObject<Block> RUBINE_ORE = BLOCKS.register("rubine_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> RUBINE_BLOCK = BLOCKS.register("rubine_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
}
