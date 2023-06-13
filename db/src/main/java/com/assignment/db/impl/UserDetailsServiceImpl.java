package com.assignment.db.impl;

import com.assignment.common.dto.UserDto;
import com.assignment.common.facade.provider.UserProviderAgent;
import com.assignment.db.mapper.DbProviderMapper;
import com.assignment.db.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class UserDetailsServiceImpl implements UserProviderAgent {

    private final UserRepository userRepository;
    private DbProviderMapper dbProviderMapper = Mappers.getMapper(DbProviderMapper.class);

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDto addUser(UserDto user) {
        log.info("saving user");
        return dbProviderMapper.userE2D(userRepository.save(dbProviderMapper.userD2E(user)));
    }
}