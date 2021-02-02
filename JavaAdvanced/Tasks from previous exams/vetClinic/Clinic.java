package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Pet> getData() {
        return this.data;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add (Pet pet){
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove (String name){
        if (!data.isEmpty()){
            for (Pet pet : data) {
               if (pet.getName().equals(name)){
                   data.remove(pet);
                   return true;
               }
            }
        }
        return false;
    }

    public Pet getPet(String name , String owner){
        Pet pet = null;
        if (!data.isEmpty()){
            for (Pet animal : data) {
                if (animal.getName().equals(name) && animal.getOwner().equals(owner)){
                    pet = animal;
                    break;
                }
            }
        }
        return pet;
    }

    public Pet getOldestPet(){
        Pet oldestPet = null;
        int ageOldestPet = -1;
        for (Pet pet : data) {
            if (pet.getAge() > ageOldestPet){
                oldestPet = pet;
                ageOldestPet = pet.getAge();
            }
        }
        return oldestPet;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:"); sb.append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()); sb.append(" "); sb.append(pet.getOwner()); sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
