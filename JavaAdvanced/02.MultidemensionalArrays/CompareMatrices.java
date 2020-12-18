import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //създаваме 2 матрици от int[]
        int[][] firstMatrix = createdMatrix(scanner);
        int[][] secondMatrix = createdMatrix(scanner);

        //правим boolean променлива за това дали 2те матрици са еднакви
        boolean isEqual = isEqualMatrix(firstMatrix , secondMatrix);
        System.out.println(isEqual ? "equal" : "not equal");//? - ако са еднакви върни "equal"
        // : ако не са върни "not equal"
    }

    private static boolean isEqualMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){//правим проверка ако имат различен брои масиви вътре
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {//пускаме цикъл да обиколи масивите
            if (firstMatrix[i].length != secondMatrix[i].length){//и сравняваме поотделно дължината на всеки масив
                return false;
            }
        }
        for (int r = 0; r < firstMatrix.length; r++) {//пускаме цикъл по масивите
            for (int c = 0; c < firstMatrix[r].length; c++) {//пускаме цикъл по елементите вътре
                if (firstMatrix[r][c] != secondMatrix[r][c]){//сравняваме елементите
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] createdMatrix(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);//прочитаме колко реда (масиви ще има)
        int cols = Integer.parseInt(tokens[1]);//прочитаме колко колони (брой елементи в масив) ще има

        int[][] matrix = new int[rows][cols];//създаваме една матрица с размери row и col

        for (int row = 0; row < rows; row++) {//пускаме един цикъл по редовете (по основните масиви)
            String[] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {//пускаме втори цикъл който обикаля елементите в масива
                matrix[row][col] = Integer.parseInt(arr[col]);
                //сравняваме matrix[масив][елемент в масива] с същото от втората матрица
            }
        }
        return matrix;
    }
}
