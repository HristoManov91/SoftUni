package course.springdata.introlab.service;

import course.springdata.introlab.entity.Account;
import course.springdata.introlab.entity.User;

import java.math.BigDecimal;

public interface AccountService {
    Account createUserAccount(User user , Account account);
    void depositMoney(BigDecimal Amount , Long accountId);
    void withdrawMoney(BigDecimal Amount , Long accountId);
    void transferMoney(BigDecimal amount , long fromAccId , long toAccId);
}
