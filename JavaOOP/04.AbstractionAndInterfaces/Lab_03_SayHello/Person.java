package Lab_03_SayHello;

public interface Person {

    String getName();

    default String sayHello(){
        return "Hello";
    };
}
