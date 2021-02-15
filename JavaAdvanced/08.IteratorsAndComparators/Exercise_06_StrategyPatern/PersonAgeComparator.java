package Exercise_06_StrategyPatern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        return Integer.compare(f.getAge() , s.getAge());
    }
}
