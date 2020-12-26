import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt";//пътя до файла

        FileInputStream inputStream = new FileInputStream(path);//променлива за входните данни

        String table = ",.!?";

        FileOutputStream outputStream = new FileOutputStream("output.txt");
        //като не зададем директория на файла се създава нов файл в папката на програмта с името което сме написали

        Scanner scanner = new Scanner(inputStream);//четем от променлива за входните данни
        while (scanner.hasNext()){//взима следващи байтове (ако няма прекъсва)
            String line = scanner.nextLine();//прочитаме ред от файла

            for (int i = 0; i < line.length(); i++) {//пускаме цикъл за всеки символ от реда
                char symbol = line.charAt(i);
                if (!table.contains(String.valueOf(symbol))){//ако таблицата не съдържа символа го отпечатай
                    outputStream.write(symbol);
                }
            }
            outputStream.write('\n');//отпечатваме символ за нов ред
        }
    }
}
