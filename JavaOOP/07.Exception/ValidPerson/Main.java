package ValidPerson;

public class Main {
    public static void main(String[] args) {

        try {
            new Person("Hristo" , "Manov" , 29);
        } catch (IllegalArgumentException | InvalidPersonNameException ex){
            System.out.println(ex.getMessage());
        }
    }
}
