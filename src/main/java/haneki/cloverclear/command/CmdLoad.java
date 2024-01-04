package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.handler.ConfigHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CmdLoad extends CmdBase {
    public CmdLoad() {
        super("load",Level.OP);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ConfigHandler.load();
        sender.sendMessage(new TextComponentString("Load config from local file."));
    }
}
