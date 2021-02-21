package bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testBankAccountCreationStartWithZeroBalance(){
        //Arrange - създава си данните
        BankAccount bankAccount = new BankAccount();

        //Act - да извика поведението
        double balance = bankAccount.getBalance();

        //Assert - да провери дали е вярно
        assertEquals( 0.0, balance ,0);//delta - допустима разлика
    }
}
