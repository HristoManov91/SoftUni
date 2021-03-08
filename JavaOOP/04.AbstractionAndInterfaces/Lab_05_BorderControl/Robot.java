package Lab_05_BorderControl;

public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot (String model , String id){
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public String getId() {
        return this.id;
    }
}
