import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotate = scanner.nextLine();
        //взимаме градусите като от индекса на ( + 1 изрязваме до дължината - 1
        int degrees = Integer.parseInt(rotate.substring(rotate.indexOf('(') + 1 , rotate.length() - 1));

        //пълним думите в един списък
        List<String> stringList = new ArrayList<>();
        String word = scanner.nextLine();
        while (!word.equals("END")){
            stringList.add(word);

            word = scanner.nextLine();
        }
        //очевидно единият размер е броя на думите а другият най-дългата дума
        int biggerLengthByWord = 0;
        for (String w : stringList) {
            if (w.length() > biggerLengthByWord){
                biggerLengthByWord = w.length();
            }
        }
        //попълваме масив като към по късите думи трябва да добавяме празни места
        char[][] matrix = new char[stringList.size()][biggerLengthByWord];
        for (int r = 0; r < matrix.length; r++) {
            char[] arr;
            if (stringList.get(r).length() < biggerLengthByWord - 1){//ако е по къса думата използваме метод за
                arr = addSpaceInArr(stringList.get(r) , biggerLengthByWord);//добавяне на спейсове
            } else {
                arr = stringList.get(r).toCharArray();//ако е най-дългата я добавяме директно като char масив
            }
            for (int c = 0; c < biggerLengthByWord; c++) {
                matrix[r][c] = arr[c];
            }
        }
        if (degrees % 360 == 0){
            printMatrix(matrix);
        }
        else if (degrees % 360 == 90){
            char[][] matrix90 = new char[biggerLengthByWord][matrix.length];
            for (int c = 0; c < biggerLengthByWord; c++) {
                char[] arr = new char[matrix.length];
                for (int r = 0; r < matrix.length; r++) {
                    arr[r] = matrix[matrix.length - 1 - r][c];
                }
                matrix90[c] = arr;
            }
            printMatrix(matrix90);
        }
        else if (degrees % 360 == 180){
            char[][] matrix180 = new char[matrix.length][biggerLengthByWord];
            for (int r = 0; r < matrix.length ; r++) {
                for (int c = 0; c < matrix[r].length ; c++) {
                    matrix180[r][c] = matrix[matrix.length - 1 - r][matrix[matrix.length - 1 - r].length - 1 - c];
                }
            }
            printMatrix(matrix180);
        }
        else if (degrees % 360 == 270){
            char[][] matrix270 = new char[biggerLengthByWord][matrix.length];
            //като редове даваме колоните от оригинала,а като колони даваме редовете
            for (int c = biggerLengthByWord - 1; c >= 0 ; c--) {//започваме цикъла от най задният елемент
                char[] arr = new char[matrix.length];
                for (int r = 0; r < matrix.length ; r++) {//започваме цикъла от 1вият ред
                    arr[r] = matrix[r][c];//
                }
                matrix270[biggerLengthByWord - 1 - c] = arr;
            }
            printMatrix(matrix270);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }

    private static char[] addSpaceInArr(String s, int biggerLengthByWord) {
        char[] arr = new char[biggerLengthByWord];
        char[] byWord = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i < byWord.length){//докато индекса го има в думата добавяме символите
                arr[i] = byWord[i];
            } else { //ако е по голям добавяме празни пространства,за да запълним
                arr[i] = ' ';
            }
        }
        return arr;
    }
}
