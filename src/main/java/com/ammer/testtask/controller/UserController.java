package com.ammer.testtask.controller;

import com.ammer.testtask.domain.dto.UserDto;
import com.ammer.testtask.service.AccountService;
import com.ammer.testtask.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Api(value = "User management")
public class UserController {

    private final UserService userService;
    private final AccountService accountService;

    @ApiOperation(
            value = "Find all users"
    )
    @GetMapping
    public ResponseEntity<Collection<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @ApiOperation(
            value = "Create user account"
    )
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(userService.create(userDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation(
            value = "Remove user"
    )
    @DeleteMapping
    public ResponseEntity<Object> remove(@ApiParam(name = "userId", required = true)
                                         @RequestParam Long userId) {
        try {
            userService.remove(userId);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ApiOperation(
            value = "Find user balance (sum all accounts)"
    )
    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> userBalance(@ApiParam(name = "userId", required = true)
                                                  @RequestParam Long userId) {
        return ResponseEntity.ok(accountService.getUserBalance(userId));
    }
}
