package haneki.cloverclear.command;

import com.feed_the_beast.ftblib.lib.command.CmdTreeBase;

public class CmdClover extends CmdTreeBase {

    public CmdClover() {
        super("clover");
        addSubcommand(new CmdClear());
        addSubcommand(new CmdLoad());
        addSubcommand(new CmdSetTime());
        addSubcommand(new CmdSetWarningTime());
        addSubcommand(new CmdTrashCan());
    }
}
