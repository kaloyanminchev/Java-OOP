package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        ValidatorInput.validateName(name);
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player player = null;
        for (Player p : this.players) {
            if (p.getName().equals(name)) {
                player = p;
            }
        }
        this.players.remove(player);
    }

    public boolean hasPlayer(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public double getRating() {
        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum() / this.players.size();
//                .average()
//                .orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.getName(), this.getRating());
    }
}
