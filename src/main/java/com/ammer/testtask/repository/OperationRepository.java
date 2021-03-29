package com.ammer.testtask.repository;

import com.ammer.testtask.domain.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Collection<Operation> findAllByFromEqualsOrToEquals(Long from, Long to);
}
