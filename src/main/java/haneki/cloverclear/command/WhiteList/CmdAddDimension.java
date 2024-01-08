package haneki.cloverclear.command.WhiteList;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.handler.ConfigHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CmdAddDimension extends CmdBase {

    public CmdAddDimension() {
        super("adddim",Level.OP);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length==0){
            sender.sendMessage(new TextComponentString("/clover whitelist adddim [dimensionID]"));
        }else {
            if (args[0].matches("^-?[1-9]\\d*|0$")){
                ConfigHandler.addDim(Integer.parseInt(args[0]));
                sender.sendMessage(new TextComponentString("Added dimension " + args[0]));
            }else {
                sender.sendMessage(new TextComponentString("NaN"));
            }
        }
    }
}
