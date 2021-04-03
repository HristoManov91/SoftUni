package CounterStriker.models.guns;

public class Pistol extends GunImpl{

    private static final int BULLETS_TO_SHOOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() >= BULLETS_TO_SHOOT){
            super.decreaseBullets(BULLETS_TO_SHOOT);
            return BULLETS_TO_SHOOT;
        } else {
            return 0;
        }
    }


}
