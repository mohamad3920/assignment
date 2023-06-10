package com.assignment.common.facade.provider;

import com.assignment.common.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserProviderAgent extends UserDetailsService {
    UserDto addUser(UserDto user);
}
