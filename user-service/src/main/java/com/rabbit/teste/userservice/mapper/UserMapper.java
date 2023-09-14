package com.rabbit.teste.userservice.mapper;

import com.rabbit.teste.userservice.dto.UserDto;
import com.rabbit.teste.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToDto(User user);

    User dtoToUser(UserDto userDto);
}
