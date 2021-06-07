package course.springdata.introlab.service.impl;

import course.springdata.introlab.dao.AccountRepository;
import course.springdata.introlab.entity.Account;
import course.springdata.introlab.entity.User;
import course.springdata.introlab.exception.InvalidAccountOperationException;
import course.springdata.introlab.exception.NoneexistingEntityException;
import course.springdata.introlab.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
    public void depositMoney(BigDecimal amount, Long accountId) {
        Account account = accRepo.findById(accountId).orElseThrow(() -> new NoneexistingEntityException(
                String.format("Entity with ID: %s does not exist", accountId))
        );

        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId) {
        Account account = accRepo.findById(accountId).orElseThrow(() -> new NoneexistingEntityException(
                String.format("Entity with ID: %s does not exist", accountId))
        );

        if (account.getBalance().compareTo(amount) < 0){
            throw new InvalidAccountOperationException(
                    String.format("Account with ID:%s balance %s is less than require amount %s",
                            accountId , account.getBalance() , amount));
        } else {
            account.setBalance(account.getBalance().subtract(amount));
        }
    }

    @Override
    public void transferMoney(BigDecimal amount, long fromAccId, long toAccId) {
        //withdraw from account
        withdrawMoney(amount , fromAccId);

        //add to account
        depositMoney(amount , toAccId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accRepo.findAll();
    }
}
