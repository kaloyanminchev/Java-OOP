package barracksWars.core.commands;

import barracksWars.interfaces.Injection;
import barracksWars.interfaces.Repository;

public class Report extends Command {
    @Injection
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
