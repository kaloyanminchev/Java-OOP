package spaceStation.core;

import spaceStation.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
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
            case AddAstronaut:
                result = addAstronaut(data);
                break;
            case AddPlanet:
                result = addPlanet(data);
                break;
            case RetireAstronaut:
                result = retireAstronaut(data);
                break;
            case ExplorePlanet:
                result = explorePlanet(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireAstronaut(String[] data) {
        return this.controller.retireAstronaut(data[0]);
    }

    private String report() {
        return this.controller.report();
    }

    private String explorePlanet(String[] data) {
        return this.controller.explorePlanet(data[0]);
    }

    private String addPlanet(String[] data) {
        if (data.length == 1) {
            return this.controller.addPlanet(data[0]);
        }
        String[] items = new String[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            items[i - 1] = data[i];
        }
        return this.controller.addPlanet(data[0], items);
    }

    private String addAstronaut(String[] data) {
        return this.controller.addAstronaut(data[0], data[1]);
    }
}
