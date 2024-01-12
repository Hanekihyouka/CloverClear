package haneki.cloverclear.handler;

import haneki.cloverclear.CloverClear;
import haneki.cloverclear.config.Setting;
import haneki.cloverclear.config.Whitelist;
import haneki.cloverclear.util.ClearUtil;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.Collections;


@Mod.EventBusSubscriber
@Config(modid = CloverClear.MODID, name = CloverClear.NAME, category = "general")
public class ConfigHandler {
    public static Setting setting = new Setting();
    public static Whitelist whitelist = new Whitelist();

    public static void load(){
        ConfigManager.load(CloverClear.MODID, Config.Type.INSTANCE);
    }
    public static void sync(){
        ConfigManager.sync(CloverClear.MODID, Config.Type.INSTANCE);
    }

    public static void setTime(int t){
        ClearEventHandler.timer = t*20;
        setting.time = t;
        sync();
    }

    public static void setWaringTime(int t){
        ClearEventHandler.warningTime = t;
        setting.warningTime = t;
        sync();
    }

    public static void addDim(int dim){
        ClearUtil.dimWhitelist.add(dim);
        whitelist.dimWhitelist = ClearUtil.dimWhitelist.toArray(new Integer[0]);
        sync();
    }

    public static void removeDim(int dim){
        ClearUtil.dimWhitelist.removeAll(Arrays.asList(dim));
        whitelist.dimWhitelist = ClearUtil.dimWhitelist.toArray(new Integer[0]);
        sync();
    }

    public static void addMod(String mod){
        ClearUtil.modWhitelist.add(mod);
        whitelist.modWhitelist = ClearUtil.modWhitelist.toArray(new String[0]);
        sync();
    }

    public static void removeMod(String mod){
        ClearUtil.modWhitelist.removeAll(Collections.singleton(mod));
        whitelist.modWhitelist = ClearUtil.modWhitelist.toArray(new String[0]);
        sync();
    }

    public static void addItem(String item){
        ClearUtil.itemWhitelist.add(item);
        whitelist.itemWhitelist = ClearUtil.itemWhitelist.toArray(new String[0]);
        sync();
    }

    public static void removeItem(String item){
        ClearUtil.itemWhitelist.removeAll(Collections.singleton(item));
        whitelist.itemWhitelist = ClearUtil.itemWhitelist.toArray(new String[0]);
        sync();
    }
}
