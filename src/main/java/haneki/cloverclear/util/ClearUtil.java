package haneki.cloverclear.util;

import haneki.cloverclear.config.Whitelist;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ClearUtil {
    public static List<String> itemWhitelist;
    public static List<String> modWhitelist;
    public static List<Integer> dimWhitelist;

    public ClearUtil(Whitelist whitelist){
        itemWhitelist = Arrays.asList(whitelist.itemWhitelist);
        modWhitelist = Arrays.asList(whitelist.modWhitelist);
        dimWhitelist = Arrays.asList(whitelist.dimWhitelist);
    }

    public HashMap<WorldServer,Integer> doServerClear(MinecraftServer server){
        HashMap<WorldServer,Integer> counterMap = new HashMap<>();
        for (WorldServer world: server.worlds) {
            Integer dim_id = world.provider.getDimension();
            if (dimWhitelist.contains(dim_id)) {
                counterMap.put(world,-1);
            }else{
                counterMap.put(world,doDimensionClear(world));
            }
        }
        return counterMap;
    }

    public int doDimensionClear(WorldServer world){
        int counter = 0;
        for (Entity entity: world.loadedEntityList) {
            if (entity instanceof EntityItem){
                EntityItem item = (EntityItem) entity;
                if (!entity.isDead){
                    String itemid = Objects.requireNonNull(item.getItem().getItem().getRegistryName()).toString();
                    if ((!itemWhitelist.contains(itemid)) && (!modWhitelist.contains(itemid.split(":")[0]))){
                        world.removeEntity(entity);
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
