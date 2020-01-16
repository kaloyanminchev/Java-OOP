package models.cards;

import models.cards.interfaces.Card;

import static common.ConstantMessages.CARD_REPORT_INFO;

public abstract class BaseCard implements Card {
    private static final int MIN_DAMAGE_POINTS = 0;
    private static final int MIN_HEALTH_POINTS = 0;

    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setDamagePoints(damagePoints);
        this.setHealthPoints(healthPoints);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Card's name cannot be null or an empty string.");
        }
        this.name = name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints < MIN_DAMAGE_POINTS) {
            throw new IllegalArgumentException("Card's damage points cannot be less than zero.");
        }
        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    private void setHealthPoints(int healthPoints) {
        if (healthPoints < MIN_HEALTH_POINTS) {
            throw new IllegalArgumentException("Card's HP cannot be less than zero.");
        }
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return String.format(CARD_REPORT_INFO, this.name, this.damagePoints);
    }
}
