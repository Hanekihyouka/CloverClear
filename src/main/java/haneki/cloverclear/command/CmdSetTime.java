package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.handler.ConfigHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CmdSetTime extends CmdBase {

    public CmdSetTime() {
        super("settime", Level.OP);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0){
            sender.sendMessage(new TextComponentString("/clover settime [seconds]"));
        }else {
            if (args[0].matches("^[1-9]\\d*$")){
                ConfigHandler.setTime(Integer.parseInt(args[0]));
                sender.sendMessage(new TextComponentString("Cycle has been set to " + args[0] + " seconds."));
            }else {
                sender.sendMessage(new TextComponentString("NaN"));
            }
        }
    }
}
