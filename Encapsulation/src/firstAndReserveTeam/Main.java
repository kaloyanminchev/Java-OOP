package firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> players = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            try {
                Person person = new Person(tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Double.parseDouble(tokens[3])
                );
                players.add(person);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Team team = new Team("Black Eagles");
        for (Person person : players) {
            team.addPlayer(person);
        }

        System.out.println(String.format("First team have %d players", team.getFirstTeam().size()));
        System.out.println(String.format("Reverse team have %d players", team.getReserveTeam().size()));
    }
}
