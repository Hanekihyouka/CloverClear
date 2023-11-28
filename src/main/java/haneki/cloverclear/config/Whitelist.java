package haneki.cloverclear.config;

import net.minecraftforge.common.config.Config;

public class Whitelist {
    @Config.Comment({"Item IDs of items to be ignored when clearing, these items will not be cleared. Format: modid:itemid, ex: minecraft:diamond"})
    public String[] itemWhitelist = {"extrautils2:suncrystal", "extrautils2:ingredients"};

    @Config.Comment({"Mod IDs of items to be ignored ex: minecraft astralsorcery appliedenergistics2"})
    public String[] modWhitelist = {"botania", "astralsorcery", "appliedenergistics2", "pneumaticcraft", "storagedrawers", "yabba", "woot"};

    @Config.Comment({"Dimension IDs to be ignored when clearing. ex: 0, 1, -1"})
    public Integer[] dimWhitelist = {1001,1002,-1003};

}
