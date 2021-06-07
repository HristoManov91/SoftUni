package course.springdata.introlab.init;

import course.springdata.introlab.entity.Account;
import course.springdata.introlab.entity.User;
import course.springdata.introlab.service.AccountService;
import course.springdata.introlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ivan Petrov" , 42);
        Account account1 = new Account(new BigDecimal(1500));

        userService.register(user1);
        accountService.createUserAccount(user1 , account1);

        accountService.withdrawMoney(new BigDecimal(1000) , account1.getId());
        accountService.depositMoney(new BigDecimal(500) , account1.getId());
        accountService.getAllAccounts().forEach(System.out::println);

        //transfer money
        User user2 = new User("Hristo Manov" , 30);
        Account account2 = new Account(new BigDecimal(15500));

        userService.register(user2);
        accountService.createUserAccount(user2 , account2);

        accountService.transferMoney(new BigDecimal(1500) , account2.getId() , account1.getId());
    }
}
