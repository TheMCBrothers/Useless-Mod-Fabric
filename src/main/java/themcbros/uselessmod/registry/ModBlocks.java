package themcbros.uselessmod.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import themcbros.uselessmod.UselessMod;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    public static final Block USELESS_ORE = registerBlock("useless_ore", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block SUPER_USELESS_ORE = registerBlock("super_useless_ore", new Block(AbstractBlock.Settings.copy(Blocks.GOLD_ORE)));
    public static final Block USELESS_BLOCK = registerBlock("useless_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block SUPER_USELESS_BLOCK = registerBlock("super_useless_block", new Block(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)));

    private static <T extends Block> T registerBlock(String registryName, T block) {
        BLOCKS.put(new Identifier(UselessMod.MOD_ID, registryName), block);
        ModItems.ITEMS.put(new Identifier(UselessMod.MOD_ID, registryName), new BlockItem(block, new Item.Settings().group(UselessMod.GROUP)));
        return block;
    }

    public static void registerBlocks() {
        BLOCKS.forEach(((identifier, block) -> Registry.register(Registry.BLOCK, identifier, block)));
    }

}
