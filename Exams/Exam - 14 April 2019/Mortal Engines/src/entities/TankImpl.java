package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40.0;
    private static final double DEFENSE_POINTS_MODIFIER = 30.0;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setAttackPoints(this.getAttackPoints() - ATTACK_POINTS_MODIFIER);
        this.setDefensePoints(this.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
        this.defenseMode = true;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenseMode = !this.defenseMode;

        if (this.defenseMode) {
            this.setAttackPoints(this.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
        } else {
            this.setAttackPoints(this.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String mode = " *Defense Mode(";
        if (this.defenseMode) {
            mode += "ON)";
        } else {
            mode += "OFF)";
        }
        return super.toString() + System.lineSeparator() + mode;
    }
}
