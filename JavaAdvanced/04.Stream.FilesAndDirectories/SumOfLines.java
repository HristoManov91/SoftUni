import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfLines {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(//четем редове от входният файл
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        Stream<String> lines = reader.lines();//пускаме stream от String (цял ред от текска)

        List<String> stringLines = lines.collect(Collectors.toList());//и ги слагаме в списък от String

        for (int i = 0; i < stringLines.size(); i++) {//пускаме цикъл по списъка
            int countASCIIValues = 0;
            char[] symbols = stringLines.get(i).toCharArray();//превръщаме в char масив всеки ред
            for (char symbol : symbols) {//взимаме всеки символ от масива
                countASCIIValues += symbol;//и го добавяме като стойност в променливата
            }
            System.out.println(countASCIIValues);//щом приключим с този ред принтираме общата стойност
        }

    }
}
