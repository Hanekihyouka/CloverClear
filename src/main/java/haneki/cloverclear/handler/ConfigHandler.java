package haneki.cloverclear.handler;

import haneki.cloverclear.CloverClear;
import haneki.cloverclear.config.Setting;
import haneki.cloverclear.config.Whitelist;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Config(modid = CloverClear.MODID, name = CloverClear.NAME, category = "general")
public class ConfigHandler {
    public static Setting setting = new Setting();
    public static Whitelist whitelist = new Whitelist();

    public static void load(){
        ConfigManager.load(CloverClear.MODID, Config.Type.INSTANCE);
    }
    
}
