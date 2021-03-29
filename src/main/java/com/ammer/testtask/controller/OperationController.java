package com.ammer.testtask.controller;

import com.ammer.testtask.domain.dto.OperationDto;
import com.ammer.testtask.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/operations")
@AllArgsConstructor
@Api(value = "Operation view")
public class OperationController {

    private final OperationService accountService;

    @ApiOperation(
            value = "Find all user account operations"
    )
    @GetMapping
    public ResponseEntity<Collection<OperationDto>> findAllByUserAccount(@ApiParam(name = "accountId", required = true) @RequestParam Long accountId) {
        return ResponseEntity.ok(accountService.findAllByUserAccount(accountId));
    }
}
