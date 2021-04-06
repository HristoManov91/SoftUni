package viceCity.models.guns;

public class Pistol extends BaseGun{

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int SHOOT_BULLETS = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() < SHOOT_BULLETS && getTotalBullets() > 0){
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
