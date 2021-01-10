package TrafficLights;

public class TrafficLights {
    private Lights lights;

    public TrafficLights (Lights light){
        this.lights = light;
    }

    public Lights getLights() {
        return this.lights;
    }

    public void update(){
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
