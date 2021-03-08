package Lab_06_Ferrari;

public class Ferrari implements Car{
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
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        //488-Spider/Brakes!/brum-brum-brum-brrrrr/Dominic Toretto
        return String.format("%s/%s/%s/%s", this.model ,  this.brakes() , this.gas() , this.driverName);
    }
}
