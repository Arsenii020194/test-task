package com.ammer.testtask.mapper;

import com.ammer.testtask.domain.dto.OperationDto;
import com.ammer.testtask.domain.entity.Operation;
import com.ammer.testtask.domain.entity.OperationType;

@org.mapstruct.Mapper(componentModel = "spring")
public interface OperationMapper extends Mapper<Operation, OperationDto> {

    default com.ammer.testtask.domain.list.OperationType map(OperationType value){
        return com.ammer.testtask.domain.list.OperationType.valueOf(value.getCode());
    }
}
