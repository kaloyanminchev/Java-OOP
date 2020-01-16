package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        switch (type) {
            case "Beginner":
                player = new Beginner(new CardRepositoryImpl(), username);
                break;
            case "Advanced":
                player = new Advanced(new CardRepositoryImpl(), username);
                break;
        }

        this.playerRepository.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        switch (type) {
            case "Magic":
                card = new MagicCard(name);
                break;
            case "Trap":
                card = new TrapCard(name);
                break;
        }

        this.cardRepository.add(card);
        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(cardName);
        this.playerRepository.find(username).getCardRepository().add(card);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);

        this.battlefield.fight(attacker, enemy);

        return String.format(FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();

        for (Player player : this.playerRepository.getPlayers()) {
            builder.append(player.toString()).append(System.lineSeparator());
            for (Card card : player.getCardRepository().getCards()) {
                builder.append(card.toString()).append(System.lineSeparator());
            }
            builder.append(DEFAULT_REPORT_SEPARATOR).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
