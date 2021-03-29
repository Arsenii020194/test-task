package com.ammer.testtask.mapper;

import com.ammer.testtask.domain.dto.UserAccountDto;
import com.ammer.testtask.domain.entity.UserAccount;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@org.mapstruct.Mapper(componentModel = "spring")
public interface AccountMapper extends Mapper<UserAccount, UserAccountDto> {

    @Override
    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "currency.code", target = "currency")
    })
    UserAccountDto entityToDto(UserAccount userAccount);

    @Override
    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "currency", target = "currency.code")
    })
    UserAccount dtoToEntity(UserAccountDto userAccountDto);
}
