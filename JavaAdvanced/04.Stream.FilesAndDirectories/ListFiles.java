import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();

        for (File f : files) {
            if (!f.isDirectory()){
                System.out.println(f.getName() + ": [" + f.length() + ']');
                //get.Name - връща името на файла , length връща дължината като размер в байтове
            }
        }
    }
}
