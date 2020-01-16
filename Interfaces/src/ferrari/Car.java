package ferrari;

public interface Car {
    default String brakes() {
        return "brum-brum-brum-brrrrr";
    }

    default String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
