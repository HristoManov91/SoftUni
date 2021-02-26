package Exercise_04_TrafficLights;

public class TrafficLights {
    private Lights lights;

    public TrafficLights (Lights lights){
        this.lights = lights;
    }

    public Lights getLights() {
        return this.lights;
    }

    public void swapLights(){
        switch (lights){
            case RED:
                this.lights = Lights.GREEN;
                break;
            case GREEN:
                this.lights = Lights.YELLOW;
                break;
            case YELLOW:
                this.lights = Lights.RED;
                break;
        }
    }
}
