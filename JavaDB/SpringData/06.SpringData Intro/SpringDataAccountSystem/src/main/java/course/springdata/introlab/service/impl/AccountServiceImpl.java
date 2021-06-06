package course.springdata.introlab.service.impl;

import course.springdata.introlab.dao.AccountRepository;
import course.springdata.introlab.entity.Account;
import course.springdata.introlab.entity.User;
import course.springdata.introlab.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accRepo;

    @Autowired
    public void setAccRepo(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }

    @Override
    public Account createUserAccount(User user, Account account) {
        account.setId(null);
        account.setUser(user);
        user.getAccounts().add(account);
        return accRepo.save(account);
    }

    @Override
    public void depositMoney(BigDecimal Amount, Long accountId) {

    }

    @Override
    public void withdrawMoney(BigDecimal Amount, Long accountId) {

    }

    @Override
    public void transferMoney(BigDecimal amount, long fromAccId, long toAccId) {

    }
}
