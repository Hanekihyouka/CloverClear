package haneki.cloverclear.config;

import net.minecraftforge.common.config.Config;

public class Setting {
    @Config.Comment({"Time in seconds between each clear"})
    public int time = 300;
    @Config.Comment({"Time in seconds clear is announced to chat before-hand, set to zero to disable warning"})
    public int warningTime = 10;
    @Config.Comment({"Set to false to disable item clearing"})
    public boolean clearItems = true;

}
