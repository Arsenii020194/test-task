package com.ammer.testtask.mapper;

import java.util.Collection;

public interface Mapper<ENTITY, DTO> {

    DTO entityToDto(ENTITY entity);

    ENTITY dtoToEntity(DTO dto);

    Collection<DTO> entityToDto(Collection<ENTITY> entity);

    Collection<ENTITY> dtoToEntity(Collection<DTO> dto);
}
