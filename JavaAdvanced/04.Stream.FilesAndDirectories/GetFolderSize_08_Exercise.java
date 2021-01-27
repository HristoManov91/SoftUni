import java.io.File;

public class GetFolderSize_08_Exercise {
    public static void main(String[] args) {
        File file = new File("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        File[] files = file.listFiles();
        int size = 0;
        for (File file1 : files) {
            size += file1.length();
        }
        System.out.printf("Folder size: %d", size);
    }
}
