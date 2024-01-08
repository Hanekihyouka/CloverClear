package haneki.cloverclear.command.WhiteList;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.handler.ConfigHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CmdAddItem extends CmdBase {

    public CmdAddItem() {
        super("additem",Level.OP);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length==0){
            sender.sendMessage(new TextComponentString("/clover whitelist additem [modid:item]"));
        }else {
            ConfigHandler.addItem(args[0]);
            sender.sendMessage(new TextComponentString("Added item " + args[0]));
        }
    }
}
