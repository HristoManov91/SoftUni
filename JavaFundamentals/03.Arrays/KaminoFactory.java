import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lengthDna = Integer.parseInt(scan.nextLine());

        int[] dnaSequence = new int[lengthDna];
        int lineCount = 0;
        int bestLine = 0;
        int bestSumOfOne = 0;
        int bestStartIndex = -1;
        int bestLength = 0;

        //longest subsequence of ones
        //leftmost starting index
        //greater sum of its elements
        String input = scan.nextLine();
        while (!input.equals("Clone them!")) {
            int[] tmp = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();

            lineCount++;
            int sumOfOne = 0;

            for (int i = 0; i < tmp.length; i++) {
                int currentLength = 0;
                int startIndex = -1;
                for (int j = i; j < tmp.length; j++) {
                    i = j;
                    if ( tmp[i] == tmp[j] && tmp[i] == 1){
                        currentLength++;
                        startIndex = i;
                        sumOfOne++;
                        if ( currentLength > bestLength){
                            dnaSequence = tmp;
                            bestStartIndex = startIndex;
                            bestLength = currentLength;
                            bestLine = lineCount;
                            bestSumOfOne = sumOfOne;
                        }
                    } else {
                        break;
                    }
                }
                if ( currentLength == bestLength ){
                    if ( startIndex < bestStartIndex ){
                        dnaSequence = tmp;
                        bestStartIndex = startIndex;
                        bestLine = lineCount;
                        bestSumOfOne = sumOfOne;
                    } else if ( startIndex == bestStartIndex && sumOfOne > bestSumOfOne){
                        dnaSequence = tmp;
                        bestLine = lineCount;
                        bestSumOfOne = sumOfOne;
                    }
                }
            }
            if ( tmp == dnaSequence ){
                bestSumOfOne = sumOfOne;
            }
            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestLine, bestSumOfOne);
        for (int num: dnaSequence) {
            System.out.print(num + " ");
        }
    }
}
