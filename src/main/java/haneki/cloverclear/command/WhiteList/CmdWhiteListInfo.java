package haneki.cloverclear.command.WhiteList;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CmdWhiteListInfo extends CmdBase {

    public CmdWhiteListInfo() {
        super("",Level.OP);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        //TODO
    }
}
