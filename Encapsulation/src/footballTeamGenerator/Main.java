package footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");

            try {
                switch (tokens[0]) {
                    case "footballTeamGenerator.Team":
                        Team team = new Team(tokens[1]);
                        teams.putIfAbsent(tokens[1], team);
                        break;
                    case "Add":
                        if (teams.containsKey(tokens[1])) {
                            Player player = new Player(tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    Integer.parseInt(tokens[6]),
                                    Integer.parseInt(tokens[7]));

                            teams.get(tokens[1]).addPlayer(player);
                        } else {
                            System.out.println(String.format("footballTeamGenerator.Team %s does not exist.", tokens[1]));
                        }
                        break;
                    case "Remove":
                        if (teams.get(tokens[1]).hasPlayer(tokens[2])) {
                            teams.get(tokens[1]).removePlayer(tokens[2]);
                        } else {
                            System.out.println(String.format("footballTeamGenerator.Player %s is not in %s team.", tokens[2], tokens[1]));
                        }
                        break;
                    case "Rating":
                        if (teams.containsKey(tokens[1])) {
                            int result = (int) Math.round(teams.get(tokens[1]).getRating());
                            System.out.println(tokens[1] + " - " + result);
//                            System.out.println(teams.get(tokens[1]).toString());
                        } else {
                            System.out.println(String.format("footballTeamGenerator.Team %s does not exist.", tokens[1]));
                        }
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
