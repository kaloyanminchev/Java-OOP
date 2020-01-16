package jedyGalaxy;

public class Engine {
    private ConsoleReader reader;
    private Enemy enemy;
    private Player player;
    private String command;

    public Engine(ConsoleReader reader, Enemy enemy, Player player) {
        this.reader = reader;
        this.enemy = enemy;
        this.player = player;
        this.command = "";
    }

    public void run() {
        this.command = this.reader.readLine();
        while (!"Let the Force be with you".equals(command)) {
            int[] positionPlayer =
                    InputParser.parseIntegerArray(this.command);

            int[] positionEnemy =
                    InputParser.parseIntegerArray(this.reader.readLine());

            int enemyRow = positionEnemy[0];
            int enemyCol = positionEnemy[1];

            enemy.destroyStars(enemyRow, enemyCol);

            int playerRow = positionPlayer[0];
            int playerCol = positionPlayer[1];

            this.player.collectStars(playerRow, playerCol);
            this.command = reader.readLine();
        }
    }
}
