package com.ammer.testtask.repository;

import com.ammer.testtask.domain.entity.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
    OperationType findFirstByCode(String code);
}
