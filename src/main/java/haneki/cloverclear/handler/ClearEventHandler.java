package haneki.cloverclear.handler;

import haneki.cloverclear.CloverClear;
import haneki.cloverclear.util.ClearUtil;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.*;

public class ClearEventHandler {
    public static int timer = ConfigHandler.setting.time * 20;
    public static int warningTime = ConfigHandler.setting.warningTime * 20;
    public static boolean isclearon = ConfigHandler.setting.clearItems;
    private static ClearUtil clearUtil = new ClearUtil(ConfigHandler.whitelist);

    public ClearEventHandler(){
    }
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (isclearon){
            if (event.phase.equals(TickEvent.Phase.START)){
                if (timer == 0){
                    StringBuilder clearMessage = new StringBuilder();
                    int total_amount = 0;
                    HashMap<WorldServer,Integer> counterMap = clearUtil.doServerClear(CloverClear.SERVER);
                    for (Map.Entry<WorldServer, Integer> dimCounter : counterMap.entrySet()) {
                        if (dimCounter.getValue() > 0) {
                            Integer dim_id = dimCounter.getKey().provider.getDimension();
                            String dim_name = dimCounter.getKey().provider.getDimensionType().name();
                            total_amount += dimCounter.getValue();
                            clearMessage.append("\n[ ").append(dim_id).append(" ] ").append(dim_name).append(":  ").append(dimCounter.getValue());
                        }
                    }
                    //TODO message ues resources and add lang files.
                    CloverClear.SERVER.getPlayerList().sendMessage(new TextComponentString(TextFormatting.YELLOW + "[CloverClear]" + TextFormatting.GRAY + clearMessage + TextFormatting.RESET + "\n" +
                             "Cleared " + TextFormatting.RED + total_amount + TextFormatting.RESET + " item-entities. The next one will be in " + ConfigHandler.setting.time + " seconds.\n Use /clover trashcan to view latest trashcan."));
                    timer = ConfigHandler.setting.time * 20;
                }
                if (timer == warningTime){
                    CloverClear.SERVER.getPlayerList().sendMessage(new TextComponentString(TextFormatting.YELLOW + "[CloverClear]" + TextFormatting.RED + " Items will be cleared in " + ConfigHandler.setting.warningTime + " seconds." + TextFormatting.RESET));
                }
                if (timer > 0){
                    timer --;
                }
            }
        }
    }

    public static void resetTimer(){
        timer = ConfigHandler.setting.time * 20;
    }
}
