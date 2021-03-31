package Singleton;

public class SingletonContainer {
    private static PopulationTracker tracker;
    private static boolean isInitialized;

    private SingletonContainer(){
    }

    public static PopulationTracker getTracker(){
        if (!isInitialized){
            throw new IllegalStateException("SingletonContainer not initialized call .init() first");
        }
        return tracker;
    }

    public static void init(){
        if (!isInitialized){
            isInitialized = true;
            tracker = PopulationTracker.getInstance();
        }
    }
}



