package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.handler.ClearEventHandler;
import haneki.cloverclear.handler.ConfigHandler;
import haneki.cloverclear.util.ClearUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CmdInfo extends CmdBase {

    public CmdInfo() {
        super("info",Level.ALL);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        StringBuilder content = new StringBuilder();
        content.append("[CloverClear]\n");
        content.append("time : ").append(ConfigHandler.setting.time).append("s   ")
                .append("waringtime : ").append(ConfigHandler.setting.warningTime).append("s   ")
                .append("nextclear : ").append(ClearEventHandler.timer/20).append("s");

        content.append("\n[Whitelist-item] : ");
        for (String item:ClearUtil.itemWhitelist){
            content.append(item).append(" , ");
        }

        content.append("\n[Whitelist-mod] : ");
        for (String mod:ClearUtil.modWhitelist){
            content.append(mod).append(" , ");
        }

        content.append("\n[Whitelist-dimension] : ");
        for (int dim:ClearUtil.dimWhitelist){
            content.append(dim).append(" , ");
        }

        sender.sendMessage(new TextComponentString(content.toString()));
    }
}
