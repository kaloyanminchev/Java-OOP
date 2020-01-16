package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.factories.GunFactory;
import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private ArrayDeque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.putIfAbsent(name, player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = GunFactory.createGun(type, name);
        if (gun == null) {
            return GUN_TYPE_INVALID;
        }
        this.guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun = this.guns.poll();

        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        }

        if (!this.players.containsKey(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        this.players.get(name).getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.players.values());

        if (this.mainPlayer.getLifePoints() == 100 && getPlayersBelowDefaultLifePoints() == 0) {
            return FIGHT_HOT_HAPPENED;
        }

        String message = FIGHT_HAPPENED
                + System.lineSeparator()
                + String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints())
                + System.lineSeparator()
                + String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, getDeadCivilPlayers(this.players.values()))
                + System.lineSeparator()
                + String.format(CIVIL_PLAYERS_LEFT_MESSAGE, getAliveCivilPlayers(this.players.values()));

        return message.trim();
    }

    private int getPlayersBelowDefaultLifePoints() {
        return (int) this.players.values().stream().filter(e -> e.getLifePoints() < 50).count();
    }

    private int getDeadCivilPlayers(Collection<Player> civilPlayers) {
        return (int) civilPlayers.stream().filter(p -> p.getLifePoints() == 0).count();
    }

    private int getAliveCivilPlayers(Collection<Player> civilPlayers) {
        return (int) civilPlayers.stream().filter(p -> p.getLifePoints() > 0).count();
    }
}
