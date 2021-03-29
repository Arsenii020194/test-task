package com.ammer.testtask.service;

import com.ammer.testtask.domain.dto.UserAccountDto;
import com.ammer.testtask.mapper.AccountMapper;
import com.ammer.testtask.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Transactional
    public void deposit(Long accountId, BigDecimal amount) {
        accountRepository.findForUpdate(accountId).ifPresent((account) -> {
            BigDecimal currentAmount = account.getAmount();
            account.setAmount(currentAmount.add(amount));
            accountRepository.save(account);
        });
    }

    @Transactional
    public void withdrawal(Long accountId, BigDecimal amount) {
        accountRepository.findForUpdate(accountId).ifPresent((account) -> {
            BigDecimal currentAmount = account.getAmount();
            account.setAmount(currentAmount.subtract(amount));
            accountRepository.save(account);
        });
    }

    @Transactional(readOnly = true)
    public Collection<UserAccountDto> findAll() {
        return accountMapper.entityToDto(accountRepository.findAll());
    }

    @Transactional
    public void remove(Long id) {
        accountRepository.findById(id).ifPresent(accountRepository::delete);
    }

    @Transactional(readOnly = true)
    public BigDecimal getUserBalance(Long userId) {
        return accountRepository.findUserBalance(userId);
    }

    @Transactional(readOnly = true)
    public BigDecimal getAccountBalance(Long accountId) {
        return accountRepository.findById(accountId).get().getAmount();
    }
}
