package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Songs> songs = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] dataSong = scanner.nextLine().split("_");
            String typeList = dataSong[0];
            String songName = dataSong[1];
            String time = dataSong[2];

            Songs song = new Songs(typeList, songName, time);
            songs.add(song);
        }
        String typeListToPrint = scanner.nextLine();
        if (typeListToPrint.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getSongName());
            }
        } else {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getTypeList().equals(typeListToPrint)) {
                    System.out.println(songs.get(i).getSongName());
                }
            }
        }
    }
}
