package Singleton;

public class Main {
    public static void main(String[] args) {
        SingletonContainer.init();

        PopulationTracker tracker = SingletonContainer.getTracker();
        tracker.add("Sofia" , 100);
        tracker.add("Plovdiv" , 200);
    }
}
