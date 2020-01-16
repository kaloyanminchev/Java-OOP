package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int DEFAULT_BULLETS_PER_BARREL = 10;
    private static final int DEFAULT_TOTAL_BULLETS = 100;
    private static final int DEFAULT_NUMBER_OF_FIRED_BULLETS = 1;

    public Pistol(String name) {
        super(name, DEFAULT_BULLETS_PER_BARREL, DEFAULT_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == 0) {
            reloadGun();

            if (this.getBulletsPerBarrel() == 0) {
                return 0;
            }
        }

        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - DEFAULT_NUMBER_OF_FIRED_BULLETS);

        return DEFAULT_NUMBER_OF_FIRED_BULLETS;
    }

    @Override
    protected void reloadGun() {
        if (this.getTotalBullets() > 0) {
            this.setBulletsPerBarrel(DEFAULT_BULLETS_PER_BARREL);
            this.setTotalBullets(this.getTotalBullets() - DEFAULT_BULLETS_PER_BARREL);
        }
    }
}
