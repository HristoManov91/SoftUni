package parrots;//package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data = new ArrayList<>();

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (name.equals(parrot.getName())) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)){
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> result = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)){
                parrot.setAvailable(false);
                result.add(parrot);
            }
        }

        return result;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append(System.lineSeparator());
        for (Parrot parrot : data) {
            sb.append(parrot.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
