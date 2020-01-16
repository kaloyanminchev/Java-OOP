package footballTeamGenerator;

public class ValidatorInput {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStats(int stats, String type) {
        if (stats < 0 || stats > 100) {
            throw new IllegalArgumentException(type + " should be between 0 and 100.");
        }
    }
}
