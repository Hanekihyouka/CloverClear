package haneki.cloverclear.handler;


import haneki.cloverclear.CloverClear;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static haneki.cloverclear.CloverClear.SERVER;


@Mod.EventBusSubscriber
public class EventHandler {
    public static int timer = ConfigHandler.setting.time * 20;
    public static int warningTime = ConfigHandler.setting.warningTime * 20;
    public static boolean isclearon = ConfigHandler.setting.clearItems;
    public static List<String> itemWhitelist = Arrays.asList(ConfigHandler.whitelist.itemWhitelist);
    public static List<String> modWhitelist = Arrays.asList(ConfigHandler.whitelist.modWhitelist);
    public static List<Integer> dimWhitelist = Arrays.asList(ConfigHandler.whitelist.dimWhitelist);

    private static Logger logger = CloverClear.logger;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (isclearon){
            if (event.phase.equals(TickEvent.Phase.START)){
                if (timer == 0){
                    int total_amount = 0;
                    StringBuilder clearMessage = new StringBuilder();
                    for (WorldServer world: SERVER.worlds) {
                        Integer dim_id = world.provider.getDimension();
                        if (dimWhitelist.contains(dim_id)) {
                            clearMessage.append("\n[").append(dim_id).append("]"  ).append(world.provider.getDimensionType().name()).append(":  ignored,  ");
                        }else{
                            int world_item_amount = 0;
                            for (Entity entity: world.loadedEntityList) {
                                if (entity instanceof EntityItem){
                                    EntityItem item = (EntityItem) entity;
                                    if (!entity.isDead){
                                        String itemid = Objects.requireNonNull(item.getItem().getItem().getRegistryName()).toString();
                                        if ((!itemWhitelist.contains(itemid)) && (!modWhitelist.contains(itemid.split(":")[0]))){
                                            world.removeEntity(entity);
                                            world_item_amount ++;
                                            total_amount ++;
                                        }
                                    }
                                }
                            }
                            clearMessage.append("\n[").append(dim_id).append("]"  ).append(world.provider.getDimensionType().name()).append(":  ").append(world_item_amount);
                        }
                    }
                    SERVER.getPlayerList().sendMessage(new TextComponentString(TextFormatting.YELLOW + "[CloverClear]" + TextFormatting.GRAY + clearMessage.toString() + TextFormatting.RESET + "\n" +
                             "Cleared " + TextFormatting.RED + total_amount + TextFormatting.RESET + " item-entities. The next one will be in " + ConfigHandler.setting.time + " seconds."));
                    timer = ConfigHandler.setting.time * 20;
                }
                if (timer == warningTime){
                    SERVER.getPlayerList().sendMessage(new TextComponentString(TextFormatting.YELLOW + "[CloverClear]" + TextFormatting.RED + " Items will be cleared in " + ConfigHandler.setting.warningTime + " seconds." + TextFormatting.RESET));
                }
                if (timer > 0){
                    timer --;
                }
            }
        }
    }
}
