package BankAccount;

public class BankAccount {
    private static int currentId = 1;//статични променлива която пази позицията на всеки акаунт
    private static double interestRate = 0.02;//статична променлива която влияе на всички акаунти,ако я променим
    //тя пак трябва да влияе на всички

    private int id;
    private double balance;
    private double interest;

    public BankAccount(){
        this.id = currentId++;
        this.interest = interestRate;
    }
    //когато метода в класа е static той няма this. трябва да е с името на класа и така се извиква
    public static void setInterest(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return this.balance * years * interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
