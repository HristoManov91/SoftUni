import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String[] array = scan.nextLine().split(" ");
//
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i < array.length - 1 ; i++) {
//            List<String> temp = new ArrayList<>();
//            temp.add(array[i]);
//            for (int j = i + 1; j < array.length; j++) {
//                if ( array[i].equals(array[j]) ){
//                    temp.add(array[j]);
//                }
//                else {
//                    break;
//                }
//            }
//            if ( temp.size() > result.size() ){
//                result = temp;
//            }
//            if ( result.size() == array.length ){
//                break;
//            }
//        }
//        for (String element: result) {
//            System.out.print(element + " ");
//        }
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bestLength = 0;
        int digit = 0;

        int currentLength = 1;
        for (int i = 0; i < array.length - 1; i++) {
            int currentElement = array[i];
            int nextElement = array[i + 1];
            if ( currentElement == nextElement ){
                currentLength++;
                if ( currentLength > bestLength ){
                    bestLength = currentLength;
                    digit = currentElement;
                }
            } else {
               currentLength = 1;
            }
        }
        for (int i = 0; i < bestLength; i++) {
            System.out.print(digit + " ");
        }
    }
}
