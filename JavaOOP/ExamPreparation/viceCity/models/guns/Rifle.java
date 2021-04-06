package viceCity.models.guns;

public class Rifle extends BaseGun{

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int SHOOT_BULLETS = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() < SHOOT_BULLETS && this.getTotalBullets() > 0){
            this.reload();
        }
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - SHOOT_BULLETS);
        return SHOOT_BULLETS;
    }

    @Override
    protected void reload() {
        this.setBulletsPerBarrel(BULLETS_PER_BARREL);
        this.setTotalBullets(this.getTotalBullets() - BULLETS_PER_BARREL);
    }
}
