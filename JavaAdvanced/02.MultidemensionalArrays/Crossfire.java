import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensionsMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensionsMatrix[0]);
        int cols = Integer.parseInt(dimensionsMatrix[1]);

        List<List<Integer>> matrix = new ArrayList<>();//правим си матриза от Листове за да можем да трием елементи
        int number = 1;
        for (int row = 0; row < rows; row++) {//въртим редовете
            matrix.add(new ArrayList<>());//на всеки ред добавяме нов Лист
            for (int col = 0; col < cols; col++) {//въртим индексите на Листа
                matrix.get(row).add(number++);//запълваме с елементи листа като след запълване увеличаваме с 1
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            int[] commandInfo = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowInMatrix = commandInfo[0];
            int colInMatrix = commandInfo[1];
            int radius = commandInfo[2];

            //въртим цикъл който започва от даденият ред - радиуса за най горният елементи и продължава
            //до реда който са дали + радиуса
            for (int i = rowInMatrix - radius; i <= rowInMatrix + radius ; i++) {
                //правим проверка дали индекса го има в матрицата и е различен от даденият ред(ще го премахнем после)
                if(isValidIndex(matrix , i , colInMatrix) && i != rowInMatrix){
                    matrix.get(i).remove(colInMatrix);//премахваме в даденият лист елемента на даденият индекс
                }
            }
            //въртим цикъл от даденият индекс в колони + радиуса,за да стигнем до последният който ни трябва
            // и го въртим до най-налкият който ни трябва колоната - радиуса
            for (int i = colInMatrix + radius; i >= colInMatrix - radius ; i--) {
                if (isValidIndex(matrix , rowInMatrix , i)){
                    matrix.get(rowInMatrix).remove(i);
                }
            }
            //премахваме ако има лист който е останал без елементи
            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }

        for (List<Integer> integerList: matrix){
            for (Integer integer: integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(List<List<Integer>> matrix, int rowInMatrix, int colInMatrix) {
        return rowInMatrix >= 0 && rowInMatrix < matrix.size()
                && colInMatrix >= 0 && colInMatrix < matrix.get(rowInMatrix).size();
    }
}
