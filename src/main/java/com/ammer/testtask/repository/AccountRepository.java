package com.ammer.testtask.repository;

import com.ammer.testtask.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT u FROM UserAccount u WHERE u.id = :id")
    Optional<UserAccount> findForUpdate(@Param("id") Long id);

    @Query(value = "SELECT SUM(acc.AMOUNT) FROM BANK.USER_ACCOUNT acc WHERE acc.ID_USER = :userId", nativeQuery = true)
    BigDecimal findUserBalance(@Param("userId") Long userId);
}
