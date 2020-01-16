package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.Command;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private ChampionshipController championshipController;
    private BufferedReader reader;

    public EngineImpl(ChampionshipController championshipController) {
        this.championshipController = championshipController;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();

                if (result.equals(Command.End.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case CreateRider:
                result = createRider(data);
                break;
            case CreateMotorcycle:
                result = createMotorcycle(data);
                break;
            case AddMotorcycleToRider:
                result = addMotorcycleToRider(data);
                break;
            case AddRiderToRace:
                result = addRiderToRace(data);
                break;
            case CreateRace:
                result = createRace(data);
                break;
            case StartRace:
                result = startRace(data);
                break;
            case End:
                result = Command.End.name();
                break;
        }

        return result.trim();
    }

    private String createRider(String[] data) {
        return this.championshipController.createRider(data[0]);
    }

    private String createMotorcycle(String[] data) {
        return this.championshipController.createMotorcycle(data[0], data[1], Integer.parseInt(data[2]));
    }

    private String addMotorcycleToRider(String[] data) {
        return this.championshipController.addMotorcycleToRider(data[0], data[1]);
    }

    private String addRiderToRace(String[] data) {
        return this.championshipController.addRiderToRace(data[0], data[1]);
    }

    private String createRace(String[] data) {
        return this.championshipController.createRace(data[0], Integer.parseInt(data[1]));
    }

    private String startRace(String[] data) {
        return this.championshipController.startRace(data[0]);
    }
}
