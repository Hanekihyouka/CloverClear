package haneki.cloverclear.command;

import haneki.cloverclear.CloverClear;
import haneki.cloverclear.handler.ConfigHandler;
import haneki.cloverclear.util.ClearUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;

import java.util.HashMap;
import java.util.Map;

public class CommandClover extends CommandBase {

    @Override
    public String getName() {
        return "clover";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "/clover clear\n" +
                "/clover settime\n" +
                "/clover setwarningtime\n" +
                "/clover whitelist additem [modid:itemid]\n" +
                "/clover whitelist removeitem [modid:itemid]\n" +
                "/clover whitelist addmod [modid]\n" +
                "/clover whitelist removemod [modid]\n" +
                "/clover whitelist adddim [dimid]\n" +
                "/clover whitelist removedim [dimid]\n";
        //TODO ues resources and add lang files.
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        //TODO
        if (args.length > 0) {
            switch (args[0]) {
                case "clear":
                    ClearUtil clearUtil = new ClearUtil(ConfigHandler.whitelist);
                    //clear and send message
                    StringBuilder clearMessage = new StringBuilder();
                    int total_amount = 0;
                    HashMap<WorldServer,Integer> counterMap = clearUtil.doServerClear(server);
                    for (Map.Entry<WorldServer, Integer> dimCounter : counterMap.entrySet()) {
                        Integer dim_id = dimCounter.getKey().provider.getDimension();
                        String dim_name = dimCounter.getKey().provider.getDimensionType().name();
                        total_amount += dimCounter.getValue();
                        clearMessage.append("\n[ ").append(dim_id).append(" ] "  ).append(dim_name).append(":  ").append(dimCounter.getValue());
                    }
                    //TODO message ues resources and add lang files.
                    CloverClear.SERVER.getPlayerList().sendMessage(new TextComponentString(TextFormatting.YELLOW + "[CloverClear]" + TextFormatting.GRAY + clearMessage + TextFormatting.RESET + "\n" +
                            "Cleared " + TextFormatting.RED + total_amount + TextFormatting.RESET + " item-entities. Used in command."));
                    return;
                case "settime":
                    //TODO
                    return;
                case "setwarningtime":
                    //TODO
                    return;
                case "whitelist":
                    //TODO
                    return;
            }
        }
    }
}
