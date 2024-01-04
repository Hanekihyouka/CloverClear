package haneki.cloverclear.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

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
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        //TODO
    }
}
