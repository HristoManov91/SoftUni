package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> bankAccountList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            switch (tokens[0]){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountList.add(bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int idToDeposit = Integer.parseInt(tokens[1]);
                    int amountToDeposit = Integer.parseInt(tokens[2]);
                    if (bankAccountList.size() >= idToDeposit){
                        bankAccountList.get(idToDeposit - 1).deposit(amountToDeposit);
                        System.out.printf("Deposited %d to ID%d%n",amountToDeposit , idToDeposit);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (bankAccountList.size() >= id){
                        System.out.printf("%.2f%n", bankAccountList.get(id - 1).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
