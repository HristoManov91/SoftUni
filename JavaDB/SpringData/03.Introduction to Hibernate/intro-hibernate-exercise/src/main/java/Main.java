import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Change PERSISTENCE UNIT NAME,USERNAME AND PASSWORD
        //If you need database i made a folder with sql file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("softuni");
        EntityManager em = emf.createEntityManager();

        Engine engine = new Engine(em);
        engine.run();
    }
}
