package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdBase;
import haneki.cloverclear.util.ClearUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.*;
import net.minecraft.server.MinecraftServer;

public class CmdTrashCan extends CmdBase{
    public CmdTrashCan(){
        super("trashcan", Level.ALL);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer){
            EntityPlayer player = getCommandSenderAsPlayer(sender);
            player.displayGUIChest(ClearUtil.trashcan);
            Scoreboard scoreboard = player.getWorldScoreboard();
            if (scoreboard.getObjective("scavenger")==null){
                scoreboard.addScoreObjective("scavenger",ScoreCriteria.DUMMY);
            }
            Score score = scoreboard.getOrCreateScore(player.getName(),scoreboard.getObjective("scavenger"));
            score.increaseScore(1);
        }
    }
}
