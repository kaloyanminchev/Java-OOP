package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    private static final int INCREASE_HEALTH_POINTS = 40;
    private static final int INCREASE_DAMAGE_POINTS_PER_CARD = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer instanceof Beginner) {
            this.addBonus(attackPlayer);
        }

        if (enemyPlayer.getClass().getSimpleName().equals("Beginner")) {
            this.addBonus(enemyPlayer);
        }

        this.bonusBeforeFight(attackPlayer);
        this.bonusBeforeFight(enemyPlayer);

        while (!attackPlayer.isDead() && !enemyPlayer.isDead()) {
            int attackerDamage = getDeckDamage(attackPlayer);
            int enemyDamage = getDeckDamage(enemyPlayer);

            enemyPlayer.takeDamage(attackerDamage);
            if (enemyPlayer.isDead()) {
                break;
            }
            attackPlayer.takeDamage(enemyDamage);
        }

    }

    private void addBonus(Player player) {
        player.setHealth(player.getHealth() + INCREASE_HEALTH_POINTS);

        player
                .getCardRepository()
                .getCards()
                .forEach(c -> c.setDamagePoints(c.getDamagePoints() + INCREASE_DAMAGE_POINTS_PER_CARD));
    }

    private void bonusBeforeFight(Player player) {
        int bonusHealthPoints = player.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        player.setHealth(player.getHealth() + bonusHealthPoints);
    }

    private int getDeckDamage(Player player) {
        return player.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
    }

}
