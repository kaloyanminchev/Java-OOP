package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50.0;
    private static final double DEFENSE_POINTS_MODIFIER = 25.0;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setAttackPoints(this.getAttackPoints() + ATTACK_POINTS_MODIFIER);
        this.setDefensePoints(this.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
        this.aggressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.aggressiveMode;

        if (this.aggressiveMode) {
            this.setAttackPoints(this.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
        } else {
            this.setAttackPoints(this.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String mode = " *Aggressive Mode(";
        if (this.aggressiveMode) {
            mode += "ON)";
        } else {
            mode += "OFF)";
        }
        return super.toString() + System.lineSeparator() + mode;
    }
}
