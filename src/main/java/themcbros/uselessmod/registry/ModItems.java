package themcbros.uselessmod.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import themcbros.uselessmod.UselessMod;

import java.util.HashMap;
import java.util.Map;

public class ModItems {

    static final Map<Identifier, Item> ITEMS = new HashMap<>();

    public static final Item USELESS_INGOT = registerItem("useless_ingot", new Item(new Item.Settings().group(UselessMod.GROUP)));
    public static final Item SUPER_USELESS_INGOT = registerItem("super_useless_ingot", new Item(new Item.Settings().group(UselessMod.GROUP)));

    private static <T extends Item> T registerItem(String registryName, T item) {
        ITEMS.put(new Identifier(UselessMod.MOD_ID, registryName), item);
        return item;
    }

    public static void registerItems() {
        ITEMS.forEach(((identifier, item) -> Registry.register(Registry.ITEM, identifier, item)));
    }

}
