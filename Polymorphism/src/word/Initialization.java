package word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandInitialisation(text);

        commandInterface.init();

        return commandInterface;
    }
}
