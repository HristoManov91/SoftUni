package Ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String model = "488-Spider";

    public Ferrari (String driverName){
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", model , brakes() , gas() , driverName);
    }
}
