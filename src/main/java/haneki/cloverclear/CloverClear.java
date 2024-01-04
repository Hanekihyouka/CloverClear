package haneki.cloverclear;

import haneki.cloverclear.handler.ClearEventHandler;
import haneki.cloverclear.handler.ConfigHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CloverClear.MODID, name = CloverClear.NAME, version = CloverClear.VERSION,
        serverSideOnly = true, acceptableRemoteVersions = "*", acceptedMinecraftVersions = "[1.12.2]")
public class CloverClear
{
    public static final String MODID = "cloverclear";
    public static final String NAME = "CloverClear";
    public static final String VERSION = "1.0";

    public static Logger logger;

    public static MinecraftServer SERVER = null;
    public CloverClear(){
        registerServerEventHandler();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
    }

    @EventHandler
    private void onServerAboutToStart(FMLServerAboutToStartEvent event) {
        SERVER = event.getServer();
        logger.info("Loaded clover clear.");
    }

    private void registerServerEventHandler() {
        ConfigHandler.load();
        ClearEventHandler eventHandler = new ClearEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);
    }
}
