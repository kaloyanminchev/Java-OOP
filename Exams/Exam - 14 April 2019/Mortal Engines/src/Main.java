import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        String input = reader.readLine();
        while (!"Over".equals(input)) {
            String[] tokens = input.split("\\s+");

            try {
                String result = "";
                switch (tokens[0]) {
                    case "Hire":
                        result = machinesManager.hirePilot(tokens[1]);
                        break;
                    case "Report":
                        result = machinesManager.pilotReport(tokens[1]);
                        break;
                    case "ManufactureTank":
                        result = machinesManager.manufactureTank(
                                tokens[1],
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3])
                        );
                        break;
                    case "ManufactureFighter":
                        result = machinesManager.manufactureFighter(tokens[1],
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3])
                        );
                        break;
                    case "Engage":
                        result = machinesManager.engageMachine(tokens[1], tokens[2]);
                        break;
                    case "Attack":
                        result = machinesManager.attackMachines(tokens[1], tokens[2]);
                        break;
                    case "DefenseMode":
                        result = machinesManager.toggleTankDefenseMode(tokens[1]);
                        break;
                    case "AggressiveMode":
                        result = machinesManager.toggleFighterAggressiveMode(tokens[1]);
                        break;
                }
                System.out.println(result);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            input = reader.readLine();
        }
    }
}
