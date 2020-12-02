import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String[] failInformation = input[input.length - 1].split("\\.");
        String fileName = failInformation[0];
        String fileType = failInformation[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileType);
    }
}
