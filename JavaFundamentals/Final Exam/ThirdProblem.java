import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThirdProblem {

    public static class User {
        String user;
        int sendMessage;
        int receivedMessage;

        public User(String user, int sendMessage, int receivedMessage) {
            this.user = user;
            this.sendMessage = sendMessage;
            this.receivedMessage = receivedMessage;
        }

        public String getUser() {
            return this.user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getSendMessage() {
            return this.sendMessage;
        }

        public void setSendMessage(int sendMessage) {
            this.sendMessage = sendMessage;
        }

        public int getReceivedMessage() {
            return this.receivedMessage;
        }

        public void setReceivedMessage(int receivedMessage) {
            this.receivedMessage = receivedMessage;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacityMessagePerUser = Integer.parseInt(scanner.nextLine());
        Map<String, User> userInformation = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Statistics")) {
            String[] command = input.split("=");
            switch (command[0]) {
                case "Add":
                    String user = command[1];
                    int send = Integer.parseInt(command[2]);
                    int received = Integer.parseInt(command[3]);

                    User newUser = new User(user, send, received);
                    if (send < capacityMessagePerUser && received < capacityMessagePerUser) {
                        userInformation.putIfAbsent(user, newUser);
                    }
                    break;
                case "Message":
                    String userSender = command[1];
                    String userReceiver = command[2];
                    if (userInformation.containsKey(userSender) && userInformation.containsKey(userReceiver)) {
                        userInformation.get(userSender)
                                .setSendMessage(userInformation.get(userSender).getSendMessage() + 1);
                        if (checkMaxCapacity(userInformation.get(userSender) , capacityMessagePerUser)){
                            userInformation.remove(userSender);
                            System.out.printf("%s reached the capacity!%n", userSender);
                        }
                        userInformation.get(userReceiver)
                                .setReceivedMessage(userInformation.get(userReceiver).getReceivedMessage() + 1);
                        if (checkMaxCapacity(userInformation.get(userReceiver) , capacityMessagePerUser)){
                            userInformation.remove(userReceiver);
                            System.out.printf("%s reached the capacity!%n", userReceiver);
                        }
                    }
                    break;
                case "Empty":
                    String userToDelete = command[1];
                    if (userToDelete.equals("All")){
                        userInformation.clear();
                    }
                    userInformation.remove(userToDelete);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", userInformation.size());
        userInformation
                .entrySet()
                .stream()
                .sorted((u1 , u2) -> {
                    int result = Integer.compare(u2.getValue().getReceivedMessage() , u1.getValue().getReceivedMessage());
                    if (result == 0){
                        result = u1.getKey().compareTo(u2.getKey());
                    }
                    return result;
                })
                .forEach(u -> System.out.printf("%s - %d%n", u.getKey() ,
                        u.getValue().getSendMessage() + u.getValue().getReceivedMessage()));
    }

    private static boolean checkMaxCapacity(User userInformation , int maxCapacity) {
        return userInformation.getSendMessage() + userInformation.getReceivedMessage() == maxCapacity;
    }
}
