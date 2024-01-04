package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.util.ClearUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CmdTrashCan extends CmdBase{
    public CmdTrashCan(){
        super("trashcan", Level.ALL);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        getCommandSenderAsPlayer(sender).displayGUIChest(ClearUtil.trashcan);
    }
}
