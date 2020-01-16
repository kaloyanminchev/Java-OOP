package barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int Gunner_HEALTH = 20;
    private static final int Gunner_DAMAGE = 20;

    public Gunner() {
        super(Gunner_HEALTH, Gunner_DAMAGE);
    }
}
