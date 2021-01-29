package StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1 , Person p2) {
        int result = p1.getName().length() - p2.getName().length();

        if (result == 0){
            result = p1.getName().toUpperCase().charAt(0) - p2.getName().toUpperCase().charAt(0);
        }
        return result;
    }
}
