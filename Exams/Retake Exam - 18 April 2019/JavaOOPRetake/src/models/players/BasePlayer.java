package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private static final int MIN_HEALTH_POINTS = 0;
    private static final int MIN_DAMAGE_POINTS = 0;

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.isDead = false;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < MIN_HEALTH_POINTS) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health = healthPoints;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < MIN_DAMAGE_POINTS) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.health -= damagePoints;

        if (this.health <= MIN_HEALTH_POINTS) {
            this.health = MIN_HEALTH_POINTS;
            this.isDead = true;
        }
    }

    @Override
    public String toString() {
        return String.format(PLAYER_REPORT_INFO, this.username, this.health, this.cardRepository.getCount());
    }
}
