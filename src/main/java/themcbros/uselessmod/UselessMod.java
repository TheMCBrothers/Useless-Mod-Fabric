package themcbros.uselessmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import themcbros.uselessmod.registry.ModBlocks;
import themcbros.uselessmod.registry.ModItems;
import themcbros.uselessmod.world.OreGeneration;

public class UselessMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "uselessmod";
    public static final String MOD_NAME = "Useless Mod";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, MOD_ID))
            .icon(() -> new ItemStack(ModItems.USELESS_INGOT)).build();

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        OreGeneration.setupOreGeneration();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}