package classBoxDataValidation;

public class Validator {

    private Validator() {
    }

    public static void validateSide(double side, String type) {
        if (side <= 0) {
            throw new IllegalArgumentException(type + " cannot be zero or negative.");
        }
    }
}
