package com.ammer.testtask.service;

import com.ammer.testtask.domain.dto.OperationDto;
import com.ammer.testtask.domain.entity.Operation;
import com.ammer.testtask.domain.list.OperationType;
import com.ammer.testtask.mapper.OperationMapper;
import com.ammer.testtask.repository.OperationRepository;
import com.ammer.testtask.repository.OperationTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;

@Service
@AllArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;
    private final OperationTypeRepository operationTypeRepository;
    private final OperationMapper operationMapper;

    @Transactional
    public void create(Long from, Long to, OperationType type) {
        var operation = new Operation();
        operation.setTo(to);
        operation.setFrom(from);
        operation.setDate(LocalDate.now());
        operation.setType(operationTypeRepository.findFirstByCode(type.name()));
        operationMapper.entityToDto(operationRepository.save(operation));
    }

    @Transactional(readOnly = true)
    public Collection<OperationDto> findAllByUserAccount(Long accountId) {
        return operationMapper.entityToDto(operationRepository.findAllByFromEqualsOrToEquals(accountId, accountId));
    }
}
