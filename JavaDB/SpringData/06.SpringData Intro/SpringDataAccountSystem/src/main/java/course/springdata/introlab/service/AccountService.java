package course.springdata.introlab.service;

import course.springdata.introlab.entity.Account;
import course.springdata.introlab.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface AccountService {
    Account createUserAccount(User user , Account account);
    void depositMoney(BigDecimal Amount , Long accountId);
    void withdrawMoney(BigDecimal Amount , Long accountId);
    void transferMoney(BigDecimal amount , long fromAccId , long toAccId);

    List<Account> getAllAccounts();
}
