import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThePianist {

    static boolean containsPiece(List<PianoPiece> list , String piece){
        boolean containsPiece = false;
        for (PianoPiece p : list) {
            if (p.getName().equals(piece)){
                containsPiece = true;
                break;
            }
        }
        return containsPiece;
    }

    static class PianoPiece {
        String name;
        String composer;
        String key;

        public PianoPiece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName(){
            return this.name;
        }

        public String getComposer(){
            return this.composer;
        }

        public String getKey(){
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPieces = Integer.parseInt(scanner.nextLine());
        List<PianoPiece> pianoPieces = new ArrayList<>();

        for (int i = 0; i < countPieces; i++) {
            String[] piecesInformation = scanner.nextLine().split("\\|");
            String name = piecesInformation[0];
            String composer = piecesInformation[1];
            String key = piecesInformation[2];
            PianoPiece p = new PianoPiece(name , composer , key);
            pianoPieces.add(p);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            String[] tokens = command.split("\\|");
            switch (tokens[0]){
                case "Add":
                    PianoPiece p = new PianoPiece(tokens[1], tokens[2] , tokens[3]);
                    if (containsPiece(pianoPieces , tokens[1])){
                        System.out.printf("%s is already in the collection!%n", p.getName());
                    } else {
                        pianoPieces.add(p);
                        System.out.printf("%s by %s in %s added to the collection!%n", p.getName() , p.getComposer(),
                                p.getKey());
                    }
                    break;
                case "Remove":
                    if (containsPiece(pianoPieces , tokens[1])){
                        System.out.printf("Successfully removed %s!%n", tokens[1]);
                        for (PianoPiece piece : pianoPieces) {
                            if (piece.getName().equals(tokens[1])){
                                pianoPieces.remove(piece);
                                break;
                            }
                        }
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
                case "ChangeKey":
                    if (containsPiece(pianoPieces , tokens[1])){
                        for (PianoPiece piece : pianoPieces) {
                            if (piece.getName().equals(tokens[1])){
                                piece.setKey(tokens[2]);
                                System.out.printf("Changed the key of %s to %s!%n", tokens[1] , tokens[2]);
                                break;
                            }
                        }
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        pianoPieces
                .stream()
                .sorted((p1 , p2) -> {
                    int result = p1.getName().compareTo(p2.getName());
                    if (result == 0){
                        result = p1.getComposer().compareTo(p2.getComposer());
                    }
                    return result;
                })
                .forEach(p -> {
                    System.out.printf("%s -> Composer: %s, Key: %s%n", p.getName() , p.getComposer() , p.getKey());
                });
    }
}
