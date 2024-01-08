package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdTreeBase;
import haneki.cloverclear.command.WhiteList.*;

public class CmdWhiteList extends CmdTreeBase {
    public CmdWhiteList() {
        super("whitelist");
        addSubcommand(new CmdAddMod());
        addSubcommand(new CmdAddItem());
        addSubcommand(new CmdAddDimension());
        addSubcommand(new CmdRemoveMod());
        addSubcommand(new CmdRemoveItem());
        addSubcommand(new CmdRemoveDimension());
    }

    //TODO
}
