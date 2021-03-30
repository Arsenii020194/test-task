package com.ammer.testtask.controller;

import com.ammer.testtask.domain.dto.UserAccountDto;
import com.ammer.testtask.service.AccountService;
import com.ammer.testtask.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;

import static com.ammer.testtask.domain.list.OperationType.DEPOSIT;
import static com.ammer.testtask.domain.list.OperationType.WITHDRAWAL;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@Api(value = "Account management")
public class AccountController {

    private final AccountService accountService;
    private final OperationService operationService;

    @ApiOperation(
            value = "Deposit funds to user account balance"
    )
    @PatchMapping("/deposit")
    public ResponseEntity<Object> deposit(@ApiParam(name = "accountId", required = true) Long accountId,
                                          @ApiParam(name = "amount", required = true) BigDecimal amount) {
        try {
            accountService.deposit(accountId, amount);
            operationService.create(null, accountId, DEPOSIT, amount);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation(
            value = "Withdrawal funds from user account balance"
    )
    @PatchMapping("/withdrawal")
    public ResponseEntity<Object> withdrawal(@ApiParam(name = "accountId", required = true) Long accountId,
                                             @ApiParam(name = "amount", required = true) BigDecimal amount) {
        try {
            accountService.withdrawal(accountId, amount);
            operationService.create(accountId, null, WITHDRAWAL, amount);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation(
            value = "Find all accounts"
    )
    @GetMapping
    public ResponseEntity<Collection<UserAccountDto>> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @ApiOperation(
            value = "Remove user account"
    )
    @DeleteMapping
    public ResponseEntity<Object> remove(@ApiParam(name = "accountId", required = true) @RequestParam Long accountId) {
        try {
            accountService.remove(accountId);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> accountBalance(@ApiParam(name = "accountId", required = true)
                                                     @RequestParam Long accountId) {
        return ResponseEntity.ok(accountService.getAccountBalance(accountId));
    }
}
