package com.ammer.testtask.service;

import com.ammer.testtask.domain.dto.UserDto;
import com.ammer.testtask.mapper.UserMapper;
import com.ammer.testtask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public Collection<UserDto> findAll() {
        return userMapper.entityToDto(userRepository.findAll());
    }

    @Transactional
    public UserDto create(UserDto userDto) {
        return userMapper.entityToDto(userRepository.save(userMapper.dtoToEntity(userDto)));
    }

    @Transactional
    public void remove(Long id) {
        userRepository.deleteById(id);
        userRepository.flush();
    }
}
