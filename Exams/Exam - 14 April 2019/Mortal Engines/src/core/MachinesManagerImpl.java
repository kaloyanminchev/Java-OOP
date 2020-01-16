package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(
            PilotFactory pilotFactory,
            MachineFactory machineFactory,
            Map<String, Pilot> pilots,
            Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {
        Pilot pilot = this.pilotFactory.createPilot(name);
        if (this.pilots.containsKey(name)) {
            return String.format(pilotExists, name);
        }
        this.pilots.put(name, pilot);
        return String.format(pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
        if (this.machines.containsKey(name)) {
            return String.format(machineExists, name);
        }
        this.machines.put(name, tank);
        return String.format(tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        if (this.machines.containsKey(name)) {
            return String.format(machineExists, name);
        }
        this.machines.put(name, fighter);
        return String.format(fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format(pilotNotFound, selectedMachineName);
        }

        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format(machineNotFound, selectedMachineName);
        }

        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);

        if (machine.getPilot() != null) {
            return String.format(machineHasPilotAlready, selectedMachineName);
        }
        pilot.addMachine(machine);
        machine.setPilot(pilot);

        return String.format(machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)) {
            return String.format(machineNotFound, attackingMachineName);
        } else if (!this.machines.containsKey(defendingMachineName)) {
            return String.format(machineNotFound, defendingMachineName);
        } else {

            Machine attackingMachine = this.machines.get(attackingMachineName);
            Machine defendingMachine = this.machines.get(defendingMachineName);

            attackingMachine.attack(defendingMachineName);

            if (attackingMachine.getAttackPoints() > defendingMachine.getDefensePoints()) {
                defendingMachine.setHealthPoints(defendingMachine.getHealthPoints() - attackingMachine.getAttackPoints());
                if (defendingMachine.getHealthPoints() < 0) {
                    defendingMachine.setHealthPoints(0);
                }
            }
            return String.format(attackSuccessful,
                    defendingMachineName,
                    attackingMachineName,
                    defendingMachine.getHealthPoints());
        }
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            return String.format(pilotNotFound, pilotName);
        }
        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Machine machine = this.machines.get(fighterName);
        if (machine instanceof Fighter) {
            ((Fighter) machine).toggleAggressiveMode();
            return String.format(fighterOperationSuccessful, fighterName);
        }
        return String.format(notSupportedOperation, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Machine machine = this.machines.get(tankName);
        if (machine instanceof Tank) {
            ((Tank) machine).toggleDefenseMode();
            return String.format(tankOperationSuccessful, tankName);
        }
        return String.format(notSupportedOperation, tankName);
    }
}
