package Lab_01_RhombusOfStars;

import java.util.Scanner;

public class Main {

    public static class Rhombus {
        private final int count;

        public Rhombus(int count){
            this.count = count;
        }

        public void printRhombus(){
            printTop(count);
            printBottom(count - 1);
        }

        private void printTop(int count){
            for (int i = 1; i <= count ; i++) {
                printRow(count - i , " ");
                printRow(i , "* ");
                System.out.println();
            }
        }

        private void printBottom(int count){
            for (int i = 0; i < count; i++) {
                printRow(i + 1 , " ");
                printRow(count - i , "* ");
                System.out.println();
            }
        }

        private void printRow(int count , String symbol){
            for (int i = 0; i < count; i++) {
                System.out.print(symbol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Rhombus rhombus = new Rhombus(number);

        rhombus.printRhombus();
    }
}
