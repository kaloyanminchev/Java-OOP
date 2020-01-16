package barracksWars.core.commands;

import barracksWars.interfaces.Injection;
import barracksWars.interfaces.Repository;

import javax.naming.OperationNotSupportedException;

public class Retire extends Command {
    @Injection
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String type = this.getData()[1];

        String result;
        try {
            this.repository.removeUnit(this.getData()[1]);
            result = type + " retired!";
        } catch (OperationNotSupportedException e) {
            result = e.getMessage();
        }

        return result;
    }
}
