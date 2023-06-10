package com.assignment.db.mapper;

import com.assignment.common.dto.UserDto;
import com.assignment.db.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto userE2D(UserEntity request);
    UserEntity userD2E(UserDto request);
}
