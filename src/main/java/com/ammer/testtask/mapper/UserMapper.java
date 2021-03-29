package com.ammer.testtask.mapper;

import com.ammer.testtask.domain.dto.UserDto;
import com.ammer.testtask.domain.entity.User;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserMapper extends Mapper<User, UserDto> {
}
