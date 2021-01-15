package SayHello;

public interface Person {

    String getName();

    default String sayHello(){//така правим default метод и всеки който го извика получава този резултат освен ако не е
        //пренаписан
        return "Hello";
    }
}
