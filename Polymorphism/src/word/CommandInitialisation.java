package word;

import java.util.List;

public class CommandInitialisation extends CommandImpl {
    public CommandInitialisation(StringBuilder text) {
        super(text);
    }

    @Override
    public List<Command> initCommands() {
        List<Command> list = super.initCommands();

        CutTransform cutTransform = new CutTransform();
        list.add(new Command("cut", cutTransform));
        list.add(new Command("paste", new PasteTransform(cutTransform)));

        return list;
    }
}
